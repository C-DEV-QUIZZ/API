package com.CDev.Quizz.utils;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


////T1kAfwA78ar représente la token

@Component
public class EmailServiceImpl {

    public String msgFrom ="ff-dev@outlook.fr";

    public Boolean sendInscriptionMail(String to,String tokenEncrypt, String prenomUser, JavaMailSender javaMail) {
        System.out.println("Envoi mail inscription en cours...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(msgFrom);
        message.setTo(to);
        message.setSubject("Inscription GTA LIFE");
        message.setText(
                "Bonjour et Bienvenue " + prenomUser +" ! \n\n" +
                        "Nous te souhaitons la bienvenue dans le serveur !\n\n" +
                        "Nous espérons que tu t'amuseras comme il se doit. Avant toutes choses tu va devoir confirmer ton inscription" +
                        "en cliquant sur ce lien :\n\n\t" +
                        "http://localhost:4200/confirmationInscription?T1kAfwA78ar="+ tokenEncrypt +"\n\n\n" +
                        "Une fois cela fais, tu pourras te connecter à ton compte !\n\n" +
                        "Cdlt\n\n\n" +
                        "L'équipe de GTA LIFE"
        );

        javaMail.send(message);
        System.out.println("Email envoye!");
        return true;
    }

    public Boolean sendSimpleMessage(String to, String subject, String text, JavaMailSender javaMail) {
        System.out.println("Envoi mail en cours...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(msgFrom);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMail.send(message);
        System.out.println("Email envoye!");
        return true;
    }

    public Boolean sendMail(String to, String subject, String body, JavaMailSender javaMail) throws MessagingException {
        System.out.println("Envoi mail en cours...");
        MimeMessage message =  javaMail.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, true);//true indicates multipart message

        helper.setFrom(msgFrom); // <--- THIS IS IMPORTANT

        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body, true);//true indicates body is html
        javaMail.send(message);

        System.out.println("Email envoye!");
        return true;
    }





}