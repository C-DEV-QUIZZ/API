package com.CDev.Quizz.entite;

import javax.persistence.*;

@Entity
@Table(name = "Utilisateurs")
public class Utilisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUtilisateurs")
    public Integer id;

    @Column(name = "NomUtilisateurs")
    public String nom;

    @Column(name = "PrenomUtilisateurs")
    public String prenom;

    @Column(name = "EmailUtilisateurs")
    public String email;

    @Column(name = "PseudoUtilisateurs")
    public String pseudo;
}
