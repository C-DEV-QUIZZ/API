package com.CDev.Quizz.entite;


import javax.persistence.*;

@Entity
@Table(name = "Administrateurs")
public class Administrateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAdministrateurs")
    private Integer id;

    @Column(name = "NomAdministrateurs")
    private String nom;

    @Column(name = "PrenomAdministrateurs")
    private String prenom;

    @Column(name = "EmailAdministrateurs")
    private String email;

    @Column(name = "PseudoAdministrateurs")
    private String pseudo;

    @Column(name = "PasswordAdministrateurs")
    private String password;

    @Column(name = "TokenAdministrateurs")
    private String token;

    @Column(name = "InscriptionConfirmAdministrateurs")
    private Boolean inscriptionComfirme;

    public Boolean getInscriptionComfirme() {
        return inscriptionComfirme;
    }

    public void setInscriptionComfirme(Boolean inscriptionComfirme) {
        this.inscriptionComfirme = inscriptionComfirme;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
