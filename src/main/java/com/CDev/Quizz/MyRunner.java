package com.CDev.Quizz;

import com.CDev.Quizz.entite.Utilisateurs;
import com.CDev.Quizz.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    UtilisateursRepository utilisateursRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Utilisateurs> utilisateursList =  utilisateursRepository.findAll();


        for(Utilisateurs users : utilisateursList)
            System.out.println(users.nom);
    }



}
