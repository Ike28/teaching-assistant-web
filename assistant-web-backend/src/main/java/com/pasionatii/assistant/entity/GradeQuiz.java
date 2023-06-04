package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "gradequiz")
@PrimaryKeyJoinColumn(name = "id")
public class GradeQuiz extends Grade {
    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;

    public GradeQuiz() {

    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
