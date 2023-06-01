package com.pasionatii.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;

    @Column(name = "text")
    private String text;

    //save files??
    @Column(name = "file")
    private byte[] file;

    public Task() {
    }

    public Task(Assignment assignment, String text, byte[] file) {
        this.assignment = assignment;
        this.text = text;
        this.file = file;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
