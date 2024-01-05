package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class EmailSenderController {
    @Autowired
    private EmailSenderService senderService;

    @PostMapping("/submit-form")
    @ResponseBody
    public String handleFormSubmit(@RequestBody User user) {
        senderService.sendEmailFromForm(user);
        senderService.sendRequest(user);
        return "Email sent successfully!";
    }

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody Map<String, Object> payload) {
        String firstName = (String) payload.get("firstName");
        String lastName = (String) payload.get("lastName");
        String email = (String) payload.get("email");
        String selectedDate = (String) payload.get("selectedDate");
        String selectedTime = (String) payload.get("selectedTime");
        String message = (String) payload.get("message");

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(email);
            helper.setSubject("Récapitulatif de votre demande de rendez-vous");
            helper.addCc("therapycupping57@gmail.com");
            helper.setText(
                    "Voici les informations que vous nous avez transmisesf:" + "\n" +
                    "Prénom: " + firstName + "\n" +
                            "Nom: " + lastName + "\n" +
                            "E-mail: " + email + "\n" +
                            "Date sélectionnée: " + selectedDate + "\n" +
                            "Heure sélectionnée:" + selectedTime + "\n" +
                            "Message: " + message + "\n" +
                            "Nous vous contacterons dès que possible pour confirmer votre rendez-vous. Si le créneau que vous avez choisi n'est pas disponible, nous vous proposerons une autre option de rendez-vous."
            );
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);

        return "E-mail envoyé avec succès !";
    }

}
