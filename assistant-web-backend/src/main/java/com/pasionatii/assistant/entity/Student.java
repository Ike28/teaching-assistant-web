package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {
    
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class className;
    public Student() {

    }

    public Student(String firstName, String lastName, Class className) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newName) {
        this.firstName = newName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newName) {
        this.lastName = newName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)  && Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, className);
    }


}
