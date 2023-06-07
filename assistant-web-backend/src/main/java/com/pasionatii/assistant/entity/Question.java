package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_quiz", insertable = false, updatable = false)
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

    public Question() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
