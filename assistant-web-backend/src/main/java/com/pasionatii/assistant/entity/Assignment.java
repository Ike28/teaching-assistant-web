package com.pasionatii.assistant.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @Column(name = "doDate")
    private LocalDateTime doDate;

    @Column(name = "text")
    private String text;


    public Assignment() {
    }

    // Constructor with all fields
    public Assignment(Course course, LocalDateTime doDate, String text) {
        this.course = course;
        this.doDate = doDate;
        this.text = text;
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getDoDate() {
        return doDate;
    }

    public void setDoDate(LocalDateTime doDate) {
        this.doDate = doDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
