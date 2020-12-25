package com.CDev.Quizz.controller;

import com.CDev.Quizz.entite.Questions;
import com.CDev.Quizz.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.List;

@RestController
@RequestMapping(value = "questions")
public class QuestionsController {

    @Autowired
    QuestionsRepository questionsRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Questions> getAllQuestions(HttpServletRequest request){
        // TODO implementer un système de vérification pour voir si
        // le demandeur est bien un administrateur
        System.out.println(request.getRemoteUser());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemotePort());
        return questionsRepository.findAll();

    }
}
