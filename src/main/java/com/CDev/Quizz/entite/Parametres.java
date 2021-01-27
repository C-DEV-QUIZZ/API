package com.CDev.Quizz.entite;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Parametres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdParametres")
    private Integer id;

    @Column(name = "NomSystemeParametres")
    private String nomSysteme;

    public String getNomSysteme() {
        return nomSysteme;
    }

    public void setNomSysteme(String nomSysteme) {
        this.nomSysteme = nomSysteme;
    }

    @Column(name = "ModeInscriptionParametres")
    private Boolean modeInscription;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getModeInscription() {
        return modeInscription;
    }

    public void setModeInscription(Boolean modeInscription) {
        this.modeInscription = modeInscription;
    }
}
