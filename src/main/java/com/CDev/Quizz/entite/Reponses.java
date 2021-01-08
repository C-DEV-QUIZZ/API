package com.CDev.Quizz.entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    // grace a JsonBackReference et à cascade = CascadeType.ALL
    // on peut lors de l'enregistre d'une question, save les
    // réponses prénsent dans l'objet question.
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JsonIgnoreProperties("reponses")
    @JoinColumn( name = "Fk_IdQuestions" , referencedColumnName="IdQuestions")
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
