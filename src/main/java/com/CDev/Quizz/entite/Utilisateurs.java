package com.CDev.Quizz.entite;

import javax.persistence.*;

@Entity
@Table(name = "Utilisateurs")
public class Utilisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUtilisateurs")
    private Integer id;

    @Column(name = "NomUtilisateurs")
    private String nom;

    @Column(name = "PrenomUtilisateurs")
    private String prenom;

    @Column(name = "EmailUtilisateurs")
    private String email;

    @Column(name = "PseudoUtilisateurs")
    private String pseudo;

    @Column(name = "PasswordUtilisateurs")
    private String password;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

}
