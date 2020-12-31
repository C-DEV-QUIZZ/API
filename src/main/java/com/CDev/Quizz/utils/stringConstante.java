package com.CDev.Quizz.utils;

public class stringConstante {

    // Ip local de l'adresse du site ( public et admin)
    public final static String IpAdresseLocal= "http://localhost:4200/";

    // adresse du site public quizz pour la confirmation d'adresse:
    public final static String IpAdresseDistant="https://siteadminquizz.servehttp.com/";

    // adresse du site administration pour la confirmation paar mail:
    public final static String IpAdresseDistantAdministration="https://siteadminquizz.servehttp.com/";

    // serveur mail:
    public final static String mailAdresseFrom="quizz-mesi@outlook.fr";

    // nom de la clé token stocké dans les cookies:
    public final static String TOKEN_KEY="Zz3Qu177";

    // nom de l'application
    public final static String NAME_APPLICATION= "QUIZZ MESI";


    public static String getMessageInscription(String prenomUser,String tokenEncrypt ) {

        return  "Bonjour et Bienvenue " + prenomUser +" ! \n\n" +
                "Nous te souhaitons la bienvenue sur "+ NAME_APPLICATION +"\n\n" +
                "Nous espérons que tu t'amuseras comme il se doit. Avant toutes choses tu va devoir confirmer ton inscription" +
                "en cliquant sur ce lien :\n\n\t" +
                IpAdresseLocal +"confirmationInscription?"+TOKEN_KEY+"="+ tokenEncrypt +"\n\n\n" +
                "Une fois cela fais, tu pourras te connecter à ton compte !\n\n" +
                "Cdlt\n\n\n" +
                "L'équipe de " + NAME_APPLICATION;

    }

    public static String getMessageInscriptionAdministrattion(String prenomUser,String tokenEncrypt ) {

        return  "Bonjour et Bienvenue " + prenomUser +" ! \n\n" +
                "Nous te souhaitons la bienvenue en tant que administrateur sur "+ NAME_APPLICATION +"\n\n" +
                "Nous espérons que tu supportera la pression d'un rôle comme le tiens !!" +
                " Avant toutes choses tu va devoir " +
                "confirmer ton inscription" +
                "en cliquant sur ce lien :\n\n\t" +
                IpAdresseLocal +"confirmationInscription?"+TOKEN_KEY+"="+ tokenEncrypt +"\n\n\n" +
                "Une fois cela fais, tu pourras te connecter à ton compte administrateur !\n\n" +
                "Cdlt\n\n\n" +
                "L'équipe de " + NAME_APPLICATION;

    }

}
