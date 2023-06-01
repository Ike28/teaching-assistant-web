package com.pasionatii.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;

    @Column(name = "text")
    private String text;

    @Column(name = "response1")
    private String response1;

    @Column(name = "response2")
    private String response2;

    @Column(name = "response3")
    private String response3;

    @Column(name = "responseCorrect")
    private String responseCorrect;

    // Constructors, getters, and setters for all the fields

    // No-argument constructor
    public Question() {
    }

    // Constructor with all fields
    public Question(Quiz quiz, String text, String response1, String response2, String response3, String responseCorrect) {
        this.quiz = quiz;
        this.text = text;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.responseCorrect = responseCorrect;
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResponse1() {
        return response1;
    }

    public void setResponse1(String response1) {
        this.response1 = response1;
    }

    public String getResponse2() {
        return response2;
    }

    public void setResponse2(String response2) {
        this.response2 = response2;
    }

    public String getResponse3() {
        return response3;
    }

    public void setResponse3(String response3) {
        this.response3 = response3;
    }

    public String getResponseCorrect() {
        return responseCorrect;
    }

    public void setResponseCorrect(String responseCorrect) {
        this.responseCorrect = responseCorrect;
    }
}
