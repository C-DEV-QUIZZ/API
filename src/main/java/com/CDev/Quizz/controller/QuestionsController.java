package com.CDev.Quizz.controller;

import com.CDev.Quizz.entite.Difficultes;
import com.CDev.Quizz.entite.Questions;
import com.CDev.Quizz.entite.Reponses;
import com.CDev.Quizz.repository.DifficultesRepository;
import com.CDev.Quizz.repository.QuestionsRepository;
import com.CDev.Quizz.repository.ReponsesRepository;
import com.CDev.Quizz.utils.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "questions")
public class QuestionsController {

    @Autowired
    QuestionsRepository questionsRepository;

    @Autowired
    DifficultesRepository difficultesRepository;

    @Autowired
    ReponsesRepository reponsesRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Questions> getAllQuestions(HttpServletRequest request){
        // TODO implementer un système de vérification pour voir si
        // le demandeur est bien un administrateur
//        System.out.println(request.getRemoteUser());
//        System.out.println(request.getRemoteAddr());
//        System.out.println(request.getRemoteHost());
//        System.out.println(request.getRemotePort());
        return questionsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @PostMapping(value = "create",produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void createQuestion(@RequestParam("question") String question,
                               @RequestParam("difficulte") Integer difficulte,
                               @RequestParam("points") Integer points,
                               @RequestParam("bonneReponse") Integer bonneReponse,
                               @RequestParam("reponses") String[] reponsesArray){

        // creer la nouvelle question a save
        Questions questions = new Questions();

        Difficultes difficultes = difficultesRepository.findById(difficulte).get();

        // creer la liste vide des reponses
        List<Reponses> reponsesList = new ArrayList();

        // parse le tableau de string des reponses
        for (String Str_reponse: reponsesArray) {

            Reponses reponse= new Reponses();   // creer un objet reponse
            reponse.setTexte(Str_reponse);      // set le texte de l'objet reponse
            // Ajoute la question a la reponse pour obtenir l'id
            // de la question a laquel la réponse est lié :
            reponse.setQuestion(questions);
            reponsesList.add(reponse);
        }

        questions.setDifficultes(difficultes);
        questions.setBonneReponse(reponsesList.get(bonneReponse));
        questions.setPoints(points);
        questions.setTexte(question);                       // set le texte de la question
        questions.setReponses(reponsesList);                // Ajoute toutes les réponses a la question
     // Ajoute la bonne réponse a la question

        // save la question et son ensemble ( réponse / bonneréponse )
        // voir entite et les relations.
        questionsRepository.save(questions);



    }

    @PutMapping(value = "update",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateQuestion(@RequestBody Questions questions) {
        if(questions.getTexte().isBlank())
            throw new IllegalArgumentException(Constante.Message.MESSAGE_VALIDATOR_QUESTION_TEXTE);

        for (Reponses reponse : questions.getReponses()) {
            if (reponse.getTexte().isBlank())
                throw new IllegalArgumentException(Constante.Message.MESSAGE_VALIDATOR_REPONSE_TEXTE);
        }
        // supprime les points d'interrogation s'il y en a et les espace blanc de fin et de début :
        questions.setTexte(questions.getTexte().replaceAll("\\?", "").trim());

        questionsRepository.save(questions);
        reponsesRepository.saveAll(questions.getReponses());
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteQuestion(@PathVariable( value = "id") Integer id){
        Optional<Questions> question = questionsRepository.findById(id);
        questionsRepository.delete(question.get());
    }

}
