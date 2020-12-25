package com.CDev.Quizz;

import com.CDev.Quizz.entite.Questions;
import com.CDev.Quizz.entite.Reponses;
import com.CDev.Quizz.entite.Utilisateurs;
import com.CDev.Quizz.repository.QuestionsRepository;
import com.CDev.Quizz.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public void run(String... args) throws Exception {
//        Questions questions = questionsRepository.findById(1).get();
//
//        System.out.println("question de difficultés : "  + questions.getDifficultes().getNom());
//        System.out.println(questions.getTexte()+ "?");
//
//        Integer idBonneReponse=  questions.getBonneReponse().getId();
//
//        for (Reponses reponses: questions.getReponses()) {
//            if(idBonneReponse == reponses.getId())
//                System.out.println(String.format("* %s *", reponses.getTextes()));
//            else
//                System.out.println(reponses.getTextes());
//        }
    }



}
