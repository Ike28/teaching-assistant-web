package com.pasionatii.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "questionresolved")
public class QuestionResolved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @Column(name = "correct")
    private boolean correct;

    public QuestionResolved() {
    }

    public QuestionResolved(Student student, Question question, boolean correct) {
        this.student = student;
        this.question = question;
        this.correct = correct;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}