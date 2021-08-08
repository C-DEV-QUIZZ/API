package com.CDev.Quizz.entite;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdQuestions")
    private Integer id;

    @Column(name = "TexteQuestions")
    private String texte;


    @Column(name = "PointsQuestions")
    private Integer points;


    // grace a referencedColumnName on fait le lien pour enregistrer l'id de la bonne réponse dans
    // table question
    @OneToOne(cascade = CascadeType.DETACH)
    @JsonIgnoreProperties("question")
    @JoinColumn(name = "Fk_IdBonneReponses" , referencedColumnName = "IdReponses") //  nullable = false)
    private Reponses bonneReponse;

    // grace a JsonManagedReference  et à cascade = CascadeType.DETACH
    // on peut lors de l'enregistre d'une question, save les
    // réponses prénsent dans l'objet question.
    @JsonManagedReference
    @JsonIgnoreProperties("question")
    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.ALL})
    private List<Reponses> reponses;

    @OneToOne()
    @JoinColumn(name = "Fk_IdDifficultes")
    private Difficultes difficultes;

    @Column(name = "IsMultiQuestions")
    private boolean isMultiplayer;

    public Difficultes getDifficultes() {
        return difficultes;
    }

    public void setDifficultes(Difficultes difficultes) {
        this.difficultes = difficultes;
    }

    public Reponses getBonneReponse() {
        return bonneReponse;
    }


    public void setBonneReponse(Reponses bonneReponse) {
        this.bonneReponse = bonneReponse;
    }
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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public List<Reponses> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponses> reponses) {
        this.reponses = reponses;
    }


}
