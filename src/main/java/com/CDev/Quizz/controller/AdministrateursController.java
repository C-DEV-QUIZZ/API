package com.CDev.Quizz.controller;


import com.CDev.Quizz.entite.Administrateurs;
import com.CDev.Quizz.repository.AdministrateursRepository;
import com.CDev.Quizz.repository.ParametresRepository;
import com.CDev.Quizz.security.Encrypte;
import com.CDev.Quizz.utils.EmailServiceImpl;
import com.CDev.Quizz.utils.MethodsTools;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping(value = "administrateurs")
public class AdministrateursController {

    // objet qui permet d'envoyé les e-mail
    EmailServiceImpl email = new EmailServiceImpl();

    // classe java qui s'oocupe du mail.
    @Autowired
    JavaMailSender javaMail;

    @Autowired
    AdministrateursRepository administrateursRepository;

    @Autowired
    ParametresRepository parametresRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/inscription")
    public Administrateurs inscriptionAdministrateur(@RequestBody Administrateurs administrateurs)
    {

        if (!parametresRepository.getOne(1).getModeInscription())
            throw new IllegalStateException("Le mode inscription est désactivé");

        if(administrateurs.getNom().isBlank())
            throw new IllegalArgumentException("Le nom ne peut pas être vide");

        if(administrateurs.getPrenom().isBlank())
            throw new IllegalArgumentException("Le prenom ne peut pas être vide");

        if(administrateurs.getEmail().isBlank())
            throw new IllegalArgumentException("L'email ne peut pas être vide");

        if(administrateurs.getPassword().isBlank())
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide");

        if (administrateursRepository.existsByEmail(administrateurs.getEmail()))
            throw new EntityExistsException("L'adresse mail existe déja");

        String token = MethodsTools.createToken(administrateurs);

        while (administrateursRepository.existsByToken(token))
            token = MethodsTools.createToken(administrateurs);

        administrateurs.setToken(token);

        administrateurs.setPassword(DigestUtils.sha256Hex(administrateurs.getPassword()));

        // crypte la token et la rend avec format url:
        String tokenEncrypter = Encrypte.encryptWithUrl(token);

        if (email.sendInscriptionMailAdministrateur(administrateurs.getEmail(),tokenEncrypter,administrateurs.getPrenom(),javaMail)){
            Administrateurs admin = administrateursRepository.save(administrateurs);
            return admin;
        }

        throw new IllegalStateException("Un problème est survenu pendant l'enregistrement");
    }

    @RequestMapping(method = RequestMethod.POST,produces=
            MediaType.APPLICATION_JSON_VALUE, value = "/confirmationInscription")
    public String getConfirmInscription(@RequestBody String token) {
        // Grace a text.plain value on récupère la token
        // mais sans l'url formatage !

        if (!parametresRepository.getOne(1).getModeInscription())
            throw new IllegalStateException("Le mode inscription est désactivé");

        String tokenDecrypt = Encrypte.decrypt(token);

        Optional<Administrateurs> administrateursOptional = administrateursRepository.findByToken(tokenDecrypt);

        if(administrateursOptional.isEmpty())
            throw new EntityNotFoundException("L'utilisateur n'as pas été trouvé");

        if(administrateursOptional.get().getInscriptionComfirme()!=null)
            throw new EntityNotFoundException("Le compte est déjà activé");

        Administrateurs admin = administrateursOptional.get();
        admin.setInscriptionComfirme(true);
        administrateursRepository.save(admin);
        return "Inscription confirmé !";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/connexion")
    public String connexionAdministrateur(@RequestBody Administrateurs administrateurs){



        // vérifie si le nom  ou le password envoyé par l'user est vide:
        if(administrateurs.getEmail().isBlank() || administrateurs.getPassword().isBlank())
            throw new IllegalArgumentException("Le mots de passe ou l'adresse mail est vide");


        // hash le mots de passe de l'utilisateurs:
        String MotDePasseHash = DigestUtils.sha256Hex(administrateurs.getPassword());

        Optional<Administrateurs> administrateursOptional=
                administrateursRepository.findByEmailAndPassword(administrateurs.getEmail(),
                        MotDePasseHash);

        if (administrateursOptional.isEmpty())
            throw new IllegalArgumentException("Login ou mots de passe incorrect ...");

            if (administrateursOptional.get().getInscriptionComfirme()!=true)
                throw new IllegalArgumentException("Vous n'avez pas confirmé votre compte...");

        // crypte la token et la rend sans format url:
        String token = Encrypte.encrypt(administrateursOptional.get().getToken());

        String JsonString = "{\"token\": \""+ token +"\","+
                "\"nom\": \""+ administrateursOptional.get().getNom().toUpperCase() +"\","+
                "\"prenom\": \""+ administrateursOptional.get().getPrenom() +"\"}";

        return  JsonString;
    }


    @RequestMapping(method = RequestMethod.POST,produces=
            MediaType.APPLICATION_JSON_VALUE, value = "/authorized")
    public Boolean ifUserAuthorized(@RequestBody String token) {

        System.out.println(token);
        String tokenDecrypt = Encrypte.decrypt(token);
        System.out.println("User Existe ? "+ administrateursRepository.existsByToken(tokenDecrypt));
        if (!administrateursRepository.existsByToken(tokenDecrypt))
            throw new IllegalStateException("Une erreur est survenu pendant la navigation");

        return true;
    }
}
