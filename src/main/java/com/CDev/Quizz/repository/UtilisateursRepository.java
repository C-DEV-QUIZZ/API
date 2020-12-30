package com.CDev.Quizz.repository;

import com.CDev.Quizz.entite.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs,Integer> {

    Optional<Utilisateurs> findByEmailAndPassword(String nom, String password);

    Boolean existsByToken(String token);

    Optional< Utilisateurs> findByToken(String token);

    Boolean existsByEmail(String mail);
}
