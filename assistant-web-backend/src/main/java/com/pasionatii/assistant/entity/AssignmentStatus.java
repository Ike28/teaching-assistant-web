package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "assignmentstatus")
public class AssignmentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;

    @OneToMany(mappedBy = "assignmentStatus")
    private Set<TaskStatus> taskStatuses;

    public AssignmentStatus() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Set<TaskStatus> getTaskStatuses() {
        return taskStatuses;
    }

    public void setTaskStatuses(Set<TaskStatus> taskStatuses) {
        this.taskStatuses = taskStatuses;
    }
}
