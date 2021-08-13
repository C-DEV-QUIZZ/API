package com.CDev.Quizz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

public class Constante {

    @Autowired
    private static Environment env;
    public static String nbQuestionModeSolo;

    public static String NbQuestionMulti;

    // adresse du site public quizz pour la confirmation d'adresse:
    public static String IpAdresseSiteAdmin;

    // serveur mail:
    public static String mailAdresseFrom;

    // nom de la clé token stocké dans les cookies:
    public static String TOKEN_KEY;

    // nom de l'application
    public final static String NAME_APPLICATION= "QUIZZ MESI";


    public static String getMessageInscription(String prenomUser,String tokenEncrypt ) {

        return  "Bonjour et Bienvenue " + prenomUser +" ! \n\n" +
                "Nous te souhaitons la bienvenue sur "+ NAME_APPLICATION +"\n\n" +
                "Nous espérons que tu t'amuseras comme il se doit. Avant toutes choses tu va devoir confirmer ton inscription " +
                "en cliquant sur ce lien :\n\n\t" +
                IpAdresseSiteAdmin +"confirmationInscription?"+TOKEN_KEY+"="+ tokenEncrypt +"\n\n\n" +
                "Une fois cela fais, tu pourras te connecter à ton compte !\n\n" +
                "Cdlt\n\n\n" +
                "L'équipe de " + NAME_APPLICATION;

    }

    public static String getMessageInscriptionAdministrattion(String prenomUser,String tokenEncrypt ) {

        return  "Bonjour et Bienvenue " + prenomUser +" ! \n\n" +
                "Nous te souhaitons la bienvenue en tant que administrateur sur "+ NAME_APPLICATION +"\n\n" +
                "Nous espérons que tu supporteras la pression d'un rôle comme le tiens !!" +
                " Avant toutes choses tu va devoir " +
                "confirmer ton inscription " +
                "en cliquant sur ce lien :\n\n\t" +
                IpAdresseSiteAdmin +"confirmationInscription?"+TOKEN_KEY+"="+ tokenEncrypt +"\n\n\n" +
                "Une fois cela fais, tu pourras te connecter à ton compte administrateur !\n\n" +
                "Cdlt\n\n\n" +
                "L'équipe de " + NAME_APPLICATION;

    }
    public static class Message{
        public final static String MESSAGE_VALIDATOR_START= "Veuillez renseigner ";
        public final static String MESSAGE_VALIDATOR_QUESTION_TEXTE= MESSAGE_VALIDATOR_START+"le texte de la question";
        public final static String MESSAGE_VALIDATOR_QUESTION_POINT= MESSAGE_VALIDATOR_START+"le nombre de point de la question";
        public final static String MESSAGE_VALIDATOR_QUESTION_BONNE_REPONSE= MESSAGE_VALIDATOR_START+"une bonne réponse";
        public final static String MESSAGE_VALIDATOR_QUESTION_REPONSES= MESSAGE_VALIDATOR_START+"au minimum une réponse";
        public final static String MESSAGE_VALIDATOR_QUESTION_DIFFICULTE= MESSAGE_VALIDATOR_START+"une difficulté";

        public final static String MESSAGE_VALIDATOR_REPONSE_TEXTE= MESSAGE_VALIDATOR_START+"le texte de la réponse";
        public final static String MESSAGE_VALIDATOR_REPONSE_QUESTION= MESSAGE_VALIDATOR_START+"la question auquel sont lié les réponses";

    }
}
