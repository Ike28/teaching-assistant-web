package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profesor")
@PrimaryKeyJoinColumn(name = "id")
public class Profesor extends User {
    private String firstname;
    private String lastname;

    public Profesor() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
