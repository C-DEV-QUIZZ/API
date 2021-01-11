package com.CDev.Quizz.controller;

import com.CDev.Quizz.utils.Constante;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "infos")
public class InfosController {


    @GetMapping(value = "typeBuild",produces = MediaType.TEXT_PLAIN_VALUE)
    public String getInfos(){
        return Constante.IpAdresseSiteAdmin;
    }
}
