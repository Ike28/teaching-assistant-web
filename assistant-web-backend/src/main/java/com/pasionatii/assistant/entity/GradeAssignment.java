package com.pasionatii.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "gradeassignment")
public class GradeAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @Column(name = "grade")
    private Integer grade;

    public GradeAssignment() {
    }

    public GradeAssignment(Assignment assignment, Student student, Integer grade) {
        this.assignment = assignment;
        this.student = student;
        this.grade = grade;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
