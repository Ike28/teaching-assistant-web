package com.pasionatii.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "gradequiz")
public class GradeQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;

    @Column(name = "grade")
    private int grade;


    public GradeQuiz() {
    }

    public GradeQuiz(Student student, Quiz quiz, int grade) {
        this.student = student;
        this.quiz = quiz;
        this.grade = grade;
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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
