package com.pasionatii.assistant.entity;


import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Class() {
    }

    public Class(String name) {
        this.name = name;
    }

}