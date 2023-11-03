package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
}
