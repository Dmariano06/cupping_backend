package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailFromForm(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("therapycupping57@gmail.com");
        message.setTo(user.getEmail());
        message.setText(user.getMessage());
        message.setSubject(user.getSubject());
        mailSender.send(message);
        System.out.println("Mail Sent...");
    }
    public void sendRequest(User user) {
        SimpleMailMessage reservation =new SimpleMailMessage();
        reservation.setFrom("therapycupping57@gmail.com");
        reservation.setTo("therapycupping57@gmail.com");
        reservation.setText(user.getReservation());
        reservation.setSubject(user.getSeller_subject());
        mailSender.send(reservation);
        System.out.println("Mail Sent for Seller");

    }
    }
