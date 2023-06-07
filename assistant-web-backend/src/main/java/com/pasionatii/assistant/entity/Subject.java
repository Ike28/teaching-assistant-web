package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Subject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

