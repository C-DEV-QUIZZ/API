package com.CDev.Quizz.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Reponses")
public class Reponses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdReponses")
    private Integer id;


    @Column(name = "TexteReponses")
    private String texte;


    @ManyToOne
    @JsonIgnoreProperties("reponses")
    @JoinColumn( name = "Fk_IdQuestions" )
    private Questions question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }
}