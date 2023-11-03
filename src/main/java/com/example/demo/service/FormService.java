package com.example.demo.service;

import com.example.demo.entity.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Autowired
    private JavaMailSender emailSender;

    public void saveAppointment(FormData appointmentData) {

    }

    public void sendConfirmationEmail(String to) {
        // Logique pour envoyer le courriel de confirmation
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("votre@gmail.com");
        message.setTo(to);
        message.setSubject("Confirmation de rendez-vous");
        message.setText("Votre rendez-vous a été confirmé avec succès.");

        emailSender.send(message);
    }
}
