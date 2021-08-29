package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TEACHER")
public class Teacher {

    @Id
    private Long id;

    private String email;

    private String firstname;

    private String surname;

    private int age;

    @Column(name = "quantityStudents")
    private int quantityStudents;

    private String imageurl;

    private String publicid;

    public Teacher(){}

    public Teacher(Long id, String email, String firstname, String surname, int age, int quantityStudents, String imageurl, String publicid) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.quantityStudents = quantityStudents;
        this.imageurl = imageurl;
        this.publicid = publicid;
    }

    public Teacher(String email, String firstname, String surname, int age, int quantityStudents, String imageurl, String publicid) {
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.quantityStudents = quantityStudents;
        this.imageurl = imageurl;
        this.publicid = publicid;
    }

    /**
     *     id ?: number,
     *     username : string,
     *     name ?: string,
     *     surname ?: string,
     *     age ?: number,
     *     quantityStudent : number,
     *     image ?: string
     */
}
