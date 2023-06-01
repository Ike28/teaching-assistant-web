package com.pasionatii.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "studenttask")
public class StudentTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_task")
    private Task task;

    @Column(name = "status")
    private Status status;

    public StudentTask() {
    }

    public StudentTask(Student student, Task task, Status status) {
        this.student = student;
        this.task = task;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
