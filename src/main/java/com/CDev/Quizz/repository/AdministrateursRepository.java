package com.CDev.Quizz.repository;

import com.CDev.Quizz.entite.Administrateurs;
import com.CDev.Quizz.entite.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministrateursRepository extends JpaRepository<Administrateurs,Integer> {

    Boolean existsByToken(String token);

    Optional<Administrateurs> findByToken(String token);

    Boolean existsByEmail(String mail);

    Optional<Administrateurs> findByEmailAndPassword(String nom, String password);

}
