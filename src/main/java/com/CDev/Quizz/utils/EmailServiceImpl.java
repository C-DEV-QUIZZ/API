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


    public Boolean sendInscriptionMail(String to,String tokenEncrypt, String prenomUser, JavaMailSender javaMail) {
        System.out.println("Envoi mail inscription en cours...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(stringConstante.mailAdresseFrom);
        message.setTo(to);
        message.setSubject("Inscription QUIZZ MESI");
        message.setText(
                stringConstante.getMessageInscription(prenomUser,tokenEncrypt)
        );
        javaMail.send(message);
        System.out.println("Email envoye!");
        return true;
    }

    public Boolean sendInscriptionMailAdministrateur(String to,String tokenEncrypt, String prenomUser,
                                             JavaMailSender javaMail) {
        System.out.println("Envoi mail inscription en cours...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(stringConstante.mailAdresseFrom);
        message.setTo(to);
        message.setSubject("Inscription QUIZZ MESI");
        message.setText(
                stringConstante.getMessageInscriptionAdministrattion(prenomUser,tokenEncrypt)
        );
        javaMail.send(message);
        System.out.println("Email envoye!");
        return true;
    }

    public Boolean sendSimpleMessage(String to, String subject, String text, JavaMailSender javaMail) {
        System.out.println("Envoi mail en cours...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(stringConstante.mailAdresseFrom);
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

        helper.setFrom(stringConstante.mailAdresseFrom); // <--- THIS IS IMPORTANT

        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body, true);//true indicates body is html
        javaMail.send(message);

        System.out.println("Email envoye!");
        return true;
    }





}