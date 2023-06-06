package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor professor;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class courseClass;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;
    @OneToMany(mappedBy ="course")
    private Set<Assignment> assignments;

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profesor getProfessor() {
        return professor;
    }

    public void setProfessor(Profesor professor) {
        this.professor = professor;
    }

    public Class getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(Class courseClass) {
        this.courseClass = courseClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
