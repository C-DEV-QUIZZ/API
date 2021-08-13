package com.CDev.Quizz.repository;

import com.CDev.Quizz.entite.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions,Integer> {
    @Query(value = "SELECT distinct * FROM Questions  WHERE IsMultiQuestions = 0 ORDER BY RANDOM() LIMIT ?",nativeQuery = true)
    List<Questions> getQuestionsForModeSolo(String nombreQuestion);

    @Query(value = "SELECT distinct * FROM Questions  WHERE IsMultiQuestions = 1 ORDER BY RANDOM() LIMIT ?",nativeQuery = true)
    List<Questions> getQuestionsForModeMulti(String nombreQuestion);
}
