package com.CDev.Quizz.controller;

import com.CDev.Quizz.entite.Administrateurs;
import com.CDev.Quizz.entite.Parametres;
import com.CDev.Quizz.repository.AdministrateursRepository;
import com.CDev.Quizz.repository.ParametresRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "parametres")
public class ParametresController {

    @Autowired
    ParametresRepository parametresRepository;

    @Autowired
    AdministrateursRepository administrateursRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/InscriptionSiteAdmin")
    public Boolean isModeInscriptionActiveSiteAdmin(){

        Parametres parametre =  parametresRepository.getOne(1);

        if(parametre == null)
            throw new EntityNotFoundException("Aucun paramètre n'as été trouvé");

        return parametre.getModeInscription();
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/getall")
    public List<Parametres> getAllParametres(){
        return parametresRepository.findAll();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "update")
    public void updateParametre(@RequestBody ObjectNode json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        // recupere dans le ObjectNode l objet administrateur:
        JsonNode adminJson = json.get("administrateur");
        // convertie le json recu en un adminsitrateur
        Administrateurs administrateurs = mapper.readValue(adminJson.toString(), new TypeReference<Administrateurs>(){});

        if(administrateurs.getEmail().isBlank())
            throw new IllegalArgumentException("L'email est vide");

        if(administrateurs.getPassword().isBlank())
            throw new IllegalArgumentException("Le mot de passe est vide");

        // teste si l'admin et le mots de passe existe
        String MotDePasseHash = DigestUtils.sha256Hex(administrateurs.getPassword());
        Optional<Administrateurs> optionalAdministrateurs=  administrateursRepository.findByEmailAndPassword(administrateurs.getEmail(),MotDePasseHash);
        if(optionalAdministrateurs.isEmpty())
            throw new IllegalAccessError("L'email ou le mots de passe est incorrect");

        // Si il existe on va pouvoir enregistrer les paramètres:

        // recupere dans le ObjectNode l objet parametres:
        JsonNode paramsJson = json.get("parametres");

        // convertie en liste de parametres:
        List<Parametres> parametres = mapper.readValue(paramsJson.toString(), new TypeReference<List<Parametres>>(){});
        if (parametres.isEmpty())
            throw new IllegalArgumentException("Les paramètres envoyé ne sont pas correct");

        parametresRepository.saveAll(parametres);

    }
}
