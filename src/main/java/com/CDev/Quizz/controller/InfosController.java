package com.CDev.Quizz.controller;

import com.CDev.Quizz.utils.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "infos")
public class InfosController {

    @Autowired
    Environment environment;

    @GetMapping(value = "typeBuild",produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public Message getInfos(){

//        String infos = String.format("Vous êtes dans un environnement de type : %s\n" +
////                "L'adresse du site admin est : %s",environment.getProperty("type.environnement"),Constante.IpAdresseSiteAdmin);//
        return new Message("Bienvenue");
    }

    public class Message{
        private String texte;

        public Message(String texte) {
            this.texte = texte;
        }

        public String getTexte() {
            return texte;
        }

        public void setTexte(String texte) {
            this.texte = texte;
        }
    }
}
