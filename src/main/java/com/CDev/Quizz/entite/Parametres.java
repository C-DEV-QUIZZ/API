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
    private String nomSystème;

    @Column(name = "ModeInscriptionParametres")
    private Boolean modeInscription;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomSystème() {
        return nomSystème;
    }

    public void setNomSystème(String nomSystème) {
        this.nomSystème = nomSystème;
    }

    public Boolean getModeInscription() {
        return modeInscription;
    }

    public void setModeInscription(Boolean modeInscription) {
        this.modeInscription = modeInscription;
    }
}
