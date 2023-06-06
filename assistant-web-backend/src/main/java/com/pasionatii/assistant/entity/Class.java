package com.pasionatii.assistant.entity;


import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @Column(name = "id")
    private Long id;


    @OneToMany(mappedBy = "assignedClass")
    private Set<Student> students;
    private String name;

    public Class() {
    }

    public Class(String name) {
        this.name = name;
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


    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
