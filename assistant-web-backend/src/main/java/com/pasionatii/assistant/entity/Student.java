package com.pasionatii.assistant.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {
    private String firstname;
    private String lastname;

    public Student(String firstname, String lastname, Class aClass) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.aClass = aClass;
    }

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class aClass;
    public Student() {
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
