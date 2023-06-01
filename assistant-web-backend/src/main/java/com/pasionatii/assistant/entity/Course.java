package com.pasionatii.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor professor;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class courseClass;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    public Course() {
    }

    public Course(int id, Profesor professor, Class courseClass, Subject subject) {
        this.id = id;
        this.professor = professor;
        this.courseClass = courseClass;
        this.subject = subject;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
