package com.spanishTongueSound.sts.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ADMIN_STS")
public class AdminSts {

    @Id
    private Long id;

    private String email;

    private String name;

    private String surname;

    public AdminSts(){}

    public AdminSts(Long id, String email, String name, String surname) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public AdminSts(String email, String name, String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;
    }
}
