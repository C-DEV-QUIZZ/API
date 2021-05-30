package com.CDev.Quizz.controller;


import com.CDev.Quizz.AbstractTest;
import com.CDev.Quizz.entite.Questions;
import com.google.gson.Gson;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AutoConfigureMockMvc
public class TestQuestionController extends AbstractTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void TestCalculQuestionIfRecupThreeResult() throws Exception {
        //given
        List<Integer> listeIdQuestion = new ArrayList<>();
        listeIdQuestion.add(1);
        listeIdQuestion.add(2);
        listeIdQuestion.add(3);
        String uri = "/questions/QuestionResult";
        String inputJson = super.mapToJson(listeIdQuestion);

        //when
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        //recupere le status
        int status = mvcResult.getResponse().getStatus();
        // recupere les reponses
        String content = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        //converti les reponses en questions:
        Gson gson = new Gson();
        Questions[] questionsArray = gson.fromJson(content, Questions[].class);

        Assertions.assertThat(status).isEqualTo(200);
        Assertions.assertThat(questionsArray.length).isEqualTo(3);
    }



}
