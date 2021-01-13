package com.CDev.Quizz.controller;


import com.CDev.Quizz.entite.Parametres;
import com.CDev.Quizz.repository.ParametresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "parametres")
public class ParametresController {

    @Autowired
    ParametresRepository parametresRepository;

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
}
