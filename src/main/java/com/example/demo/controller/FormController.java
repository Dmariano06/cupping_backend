package com.example.demo.controller;
import com.example.demo.entity.FormData;
import com.example.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class FormController {
    @Autowired
    private FormService formService;
    @PostMapping("form")
    public ResponseEntity<String> scheduleAppointment(@RequestBody FormData formData) {
        // Logique pour enregistrer le rendez-vous dans la base de données
        formService.saveAppointment(formData);

        // Envoyer le courriel de confirmation
        formService.sendConfirmationEmail(formData.getEmail());

        return ResponseEntity.ok("Rendez-vous enregistré avec succès.");
    }
}
