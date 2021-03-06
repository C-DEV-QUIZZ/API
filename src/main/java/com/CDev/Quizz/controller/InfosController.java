package com.CDev.Quizz.controller;

import com.CDev.Quizz.utils.Constante;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
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

    @GetMapping(value = "build",produces = MediaType.TEXT_PLAIN_VALUE)
    public String getInfos(){

        String infos = String.format("Vous êtes dans un environnement de type : %s\n" +
                "L'adresse du site admin est : %s\n" +
                "Version: %s",environment.getProperty("type.environnement"),Constante.IpAdresseSiteAdmin,environment.getProperty("info.app.version"));
        return infos;
    }
    @GetMapping(value = "ping",produces = MediaType.TEXT_PLAIN_VALUE)
    public String getPing(){

        return "Ping ok";
    }
}
