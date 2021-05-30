package com.CDev.Quizz.repository;

import com.CDev.Quizz.entite.Questions;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class QuestionsRepositoryTest {

    @Autowired
    QuestionsRepository questionsRepository;

    Logger logger = LoggerFactory.getLogger(QuestionsRepositoryTest.class);
    @Test
    public void TestIntegrationGetQuestionsForModeSoloNbResult(){

        //given

        //when
            List<Questions> questionsList = questionsRepository.getQuestionsForModeSolo();
        //then
            Assertions.assertThat(questionsList.size()).isEqualTo(2);

    }

    @RepeatedTest(1_000)
    public void TestIntegrationGetQuestionsForModeSoloIsResultUnique(){

        //given
            List<Questions> questionsList = questionsRepository.getQuestionsForModeSolo();
        //when
            Questions questionsA = questionsList.get(0);
            Questions questionsB = questionsList.get(1);
        //then
            Assertions.assertThat(questionsA.getId()).isNotEqualTo(questionsB.getId());
            logger.info(questionsA.getId() + " != "+ questionsB.getId());
    }

}
