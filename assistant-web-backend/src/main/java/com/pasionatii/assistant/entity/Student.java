package com.pasionatii.assistant.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Student extends User<Long>{
    
    private String firstName;
    private String lastName;
    private int classNr;
    private String classType;

    public Prof(String firstName, String lastName, int classNr, String classType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.classNr = classNr;
        this.classType = classType;
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

    public int getClassNr() {
        return classNr;
    }

    public void setClassNr(int newNr) {
        this.classNr = newNr;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String newType) {
        this.classType = newType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && classNr == that.classNr && Objects.equals(classType, that.classType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, classNr, classType);
    }


}
