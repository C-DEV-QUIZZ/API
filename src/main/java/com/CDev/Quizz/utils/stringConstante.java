package com.CDev.Quizz.utils;

public class stringConstante {

    public final static String IpAdresseLocal= "http://localhost:4200/";
    public final static String IpAdresseDistant="https://quizzAdmins.servehttp.com/";
    public final static String mailAdresseFrom="quizz-mesi@outlook.fr";
    public final static String TOKEN_KEY="Zz3Qu177";
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

}
