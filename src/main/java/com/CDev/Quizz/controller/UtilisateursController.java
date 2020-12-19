package com.CDev.Quizz.controller;

import com.CDev.Quizz.entite.Utilisateurs;
import com.CDev.Quizz.repository.UtilisateursRepository;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "utilisateurs")
public class UtilisateursController {

    // objet qui permet d'envoyé les e-mail
    EmailServiceImpl email = new EmailServiceImpl();

    // classe java qui s'oocupe du mail.
    @Autowired
    JavaMailSender javaMail;

    @Autowired
    UtilisateursRepository utilisateursRepository;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Utilisateurs> getUtilisateurs(){
        return utilisateursRepository.findAll();
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/inscription")
    public Utilisateurs inscriptionUtilisateur(@RequestBody Utilisateurs utilisateurs)
    {
        if(utilisateurs.getNom().isBlank())
            throw new IllegalArgumentException("Le nom ne peut pas être vide");

        if(utilisateurs.getPrenom().isBlank())
            throw new IllegalArgumentException("Le prenom ne peut pas être vide");

        if(utilisateurs.getEmail().isBlank())
            throw new IllegalArgumentException("L'email ne peut pas être vide");

        if(utilisateurs.getPassword().isBlank())
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide");

        if (utilisateursRepository.existsByEmail(utilisateurs.getEmail()))
            throw new EntityExistsException("L'adresse mail existe déja");

        String token = MethodsTools.createToken(utilisateurs);
        while (utilisateursRepository.existsByToken(token))
            token = MethodsTools.createToken(utilisateurs);

        utilisateurs.setToken(token);
        utilisateurs.setPassword(DigestUtils.sha256Hex(utilisateurs.getPassword()));

        // crypte la token et la rend avec format url:
        String tokenEncrypter = Encrypte.encryptWithUrl(token);

        System.out.println(utilisateurs.getNom());
        System.out.println(utilisateurs.getPrenom());
        System.out.println(utilisateurs.getEmail());
        System.out.println(utilisateurs.getPassword());
        System.out.println(utilisateurs.getToken());

        if (email.sendInscriptionMail(utilisateurs.getEmail(),tokenEncrypter,utilisateurs.getPrenom(),javaMail)){
            Utilisateurs users = utilisateursRepository.save(utilisateurs);
            return users;
        }

        throw new IllegalStateException("Un problème est survenu pendant l'enregistrement");
    }


    @RequestMapping(method = RequestMethod.POST,produces=
            MediaType.APPLICATION_JSON_VALUE, value = "/confirmationInscription")
    public String getConfirmInscription(@RequestBody String token) {
        // Grace a text.plain value on récupère la token
        // mais sans l'url formatage !

        System.out.println(token);

        String tokenDecrypt = Encrypte.decrypt(token);

        Optional<Utilisateurs> utilisateursOptional = utilisateursRepository.findByToken(tokenDecrypt);

        if(utilisateursOptional.isEmpty())
            throw new EntityNotFoundException("L'utilisateur n'as pas été trouvé");

        if(utilisateursOptional.get().getInscriptionComfirme()!=null)
            throw new EntityNotFoundException("Le compte est déjà activé");

        Utilisateurs users = utilisateursOptional.get();
        users.setInscriptionComfirme(true);
        utilisateursRepository.save(users);
        return "Inscription confirmé !";
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/connexion")
    public String connexionUtilisateurs(HttpServletResponse response, @RequestBody Utilisateurs utilisateurs){


        // vérifie si le nom  ou le password envoyé par l'user est vide:
        if(utilisateurs.getEmail().isBlank() || utilisateurs.getPassword().isBlank())
            throw new IllegalArgumentException("Le mots de passe ou l'adresse mail est vide");


        // hash le mots de passe de l'utilisateurs:
        String MotDePasseHash = DigestUtils.sha256Hex(utilisateurs.getPassword());

        Optional<Utilisateurs> utilisateursOptional=
                utilisateursRepository.findByEmailAndPassword(utilisateurs.getEmail(),
                        MotDePasseHash);

        if (utilisateursOptional.isEmpty())
            throw new IllegalArgumentException("Login ou mots de passe incorrect ...");

        // crypte la token et la rend sans format url:
        String token = Encrypte.encrypt(utilisateursOptional.get().getToken());

        String JsonString = "{\"token\": \""+ token +"\","+
                "\"nom\": \""+ utilisateursOptional.get().getNom().toUpperCase() +"\","+
                "\"prenom\": \""+ utilisateursOptional.get().getPrenom() +"\"}";

        return  JsonString;
    }






}
