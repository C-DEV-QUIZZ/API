package com.CDev.Quizz.repository;

import com.CDev.Quizz.entite.Questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions,Integer> {

    @Query(value = "SELECT distinct * FROM Questions ORDER BY RANDOM() LIMIT 2",nativeQuery = true)
    List<Questions> getQuestionsForModeSolo();
}
