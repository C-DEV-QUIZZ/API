package com.CDev.Quizz.utils;

import com.CDev.Quizz.entite.Administrateurs;
import com.CDev.Quizz.entite.Utilisateurs;

import java.util.Random;

public  class MethodsTools {



    public static String createToken(Utilisateurs user){
        String token = "";
        token = generateRandomChars(5) + user.getNom().substring(0,2).toUpperCase() +
                generateRandomChars(5) + System.currentTimeMillis() +
                generateRandomChars(5) + user.getPrenom().substring(0,2).toUpperCase()+
                generateRandomChars(5);
        return token;
    }

    public static String createToken(Administrateurs user){
        String token = "";
        token = generateRandomChars(5) + user.getNom().substring(0,2).toUpperCase() +
                generateRandomChars(5) + System.currentTimeMillis() +
                generateRandomChars(5) + user.getPrenom().substring(0,2).toUpperCase()+
                generateRandomChars(5);
        return token;
    }

    private static String generateRandomChars(int length) {
        String candidateChars ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }
}

