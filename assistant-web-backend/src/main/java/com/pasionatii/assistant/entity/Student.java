package com.pasionatii.assistant.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_class", insertable = false, updatable = false)
    private Class assignedClass;
    private String firstname;
    private String lastname;

    public Student() {
    }

    public Student(String firstname, String lastname, Class assignedClass) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.assignedClass = assignedClass;
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

    public Class getAssignedClass() {
        return assignedClass;
    }

    public void setAssignedClass(Class assignedClass) {
        this.assignedClass = assignedClass;
    }
}
