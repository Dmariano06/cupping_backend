package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "sequence_name_user", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column
    private String email;
    @Column
    private String subject = "Confirmation  de la récéption de votre demande de rendez-vous";

    public String getSeller_subject() {
        return seller_subject;
    }

    public void setSeller_subject(String seller_subject) {
        this.seller_subject = seller_subject;
    }

    @Column
    private String seller_subject = "Demande de Rendez-vous";
    @Column
    private String message= "votre mail a bien été pris en compte nous vous contacterons au plus vite ";

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    @Column(name = "reservation")
    private String reservation;
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
