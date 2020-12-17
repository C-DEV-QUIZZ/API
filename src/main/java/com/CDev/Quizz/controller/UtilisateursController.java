package com.CDev.Quizz.controller;

import com.CDev.Quizz.entite.Utilisateurs;
import com.CDev.Quizz.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "utilisateurs")
public class UtilisateursController {

    @Autowired
    UtilisateursRepository utilisateursRepository;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Utilisateurs> getUtilisateurs(){
        return utilisateursRepository.findAll();
    }
}
