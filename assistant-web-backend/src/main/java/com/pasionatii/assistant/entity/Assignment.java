package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "assignment")
    private Set<AssignmentStatus> assignmentStatuses;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_course", nullable = false, insertable = false, updatable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_class", nullable = false, insertable = false, updatable = false)
    private Class assignedClass;

    @Column(name = "do_date")
    private LocalDateTime dueDate;

    @Column(name = "text")
    private String text;


    public Assignment() {

    }

    // Constructor with all fields
    public Assignment(Course course, Class assignedClass, LocalDateTime dueDate, String text) {
        this.course = course;
        this.assignedClass = assignedClass;
        this.dueDate = dueDate;
        this.text = text;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime doDate) {
        this.dueDate = doDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
}
