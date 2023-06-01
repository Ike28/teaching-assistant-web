package com.pasionatii.assistant.entity;
import javax.persistence.*;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User {

    public Admin() {
        super();
    }
}
