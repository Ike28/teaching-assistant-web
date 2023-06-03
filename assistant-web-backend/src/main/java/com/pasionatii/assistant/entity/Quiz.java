package com.pasionatii.assistant.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "doDate")
    private LocalDateTime doDate;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;


    public Quiz() {
    }

    public Quiz(String title, LocalDateTime doDate, Course course) {
        this.title = title;
        this.doDate = doDate;
        this.course = course;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDoDate() {
        return doDate;
    }

    public void setDoDate(LocalDateTime doDate) {
        this.doDate = doDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
