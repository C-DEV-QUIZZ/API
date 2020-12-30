package com.CDev.Quizz.entite;

import javax.persistence.*;

@Entity
@Table(name = "Difficultes")
public class Difficultes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDifficultes")
    private Integer id;

    @Column(name = "NomDifficultes")
    private String nom;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
