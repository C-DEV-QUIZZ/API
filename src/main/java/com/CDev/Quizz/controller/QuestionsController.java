package com.CDev.Quizz.controller;

import com.CDev.Quizz.entite.Questions;
import com.CDev.Quizz.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "questions")
public class QuestionsController {

    @Autowired
    QuestionsRepository questionsRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Questions> getAllQuestions(){
        // TODO implementer un système de vérification pour voir si
        // le demandeur est bien un administrateur

        return questionsRepository.findAll();

    }
}
