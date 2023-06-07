package com.pasionatii.assistant.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")
@Inheritance(strategy = InheritanceType.JOINED)
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "id_student", insertable = false, updatable = false)
    private Student student;

    public Grade() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer grade) {
        this.value = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
