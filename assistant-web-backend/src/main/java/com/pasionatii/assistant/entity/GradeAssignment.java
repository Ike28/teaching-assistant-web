package com.pasionatii.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "gradeassignment")
@PrimaryKeyJoinColumn(name = "id")
public class GradeAssignment extends Grade {
    @ManyToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;

    public GradeAssignment() {

    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
