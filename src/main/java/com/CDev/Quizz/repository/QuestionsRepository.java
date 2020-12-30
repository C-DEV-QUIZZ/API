package com.CDev.Quizz.repository;

import com.CDev.Quizz.entite.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions,Integer> {
}
