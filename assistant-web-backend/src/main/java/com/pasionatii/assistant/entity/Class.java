package com.pasionatii.assistant.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Constructors, getters, and setters

    public Class() {
    }

    public Class(String name) {
        this.name = name;
    }

}
