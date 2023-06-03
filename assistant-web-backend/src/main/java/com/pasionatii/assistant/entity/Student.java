package com.pasionatii.assistant.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class assignedClass;
    private String firstname;
    private String lastname;
    @OneToMany(mappedBy = "student")
    private Set<AssignmentStatus> assignmentStatuses;
    @OneToMany(mappedBy = "student")
    private Set<Grade> grades;

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

    public Set<AssignmentStatus> getAssignmentStatuses() {
        return assignmentStatuses;
    }

    public void setAssignmentStatuses(Set<AssignmentStatus> assignmentStatuses) {
        this.assignmentStatuses = assignmentStatuses;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}
