package com.CDev.Quizz.controller;

import com.CDev.Quizz.entite.Questions;
import com.CDev.Quizz.repository.QuestionsRepository;
import com.CDev.Quizz.utils.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "infos")
public class InfosController {


    @Autowired
    QuestionsRepository questionsRepository;
    @RequestMapping(method = RequestMethod.GET, value = "/type",produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Questions> getAllQuestions(HttpServletRequest request){
        // TODO implementer un système de vérification pour voir si
        // le demandeur est bien un administrateur
//        System.out.println(request.getRemoteUser());
//        System.out.println(request.getRemoteAddr());
//        System.out.println(request.getRemoteHost());
//        System.out.println(request.getRemotePort());
        return questionsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
