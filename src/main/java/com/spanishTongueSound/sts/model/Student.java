package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    private Long id;

    private String email;

    private String firstname;

    private String surname;

    private int age;

    private int currentLevel;

    private Long idPlan;

    private boolean statusPayment;

    private String imageurl;

    private String publicid;

    public Student(){}

    public Student(Long id, String email, String firstname, String surname, int age, int currentLevel, Long idPlan, boolean statusPayment, String imageurl, String publicid) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.currentLevel = currentLevel;
        this.idPlan = idPlan;
        this.statusPayment = statusPayment;
        this.imageurl = imageurl;
        this.publicid = publicid;
    }

    public Student(String email, String firstname, String surname, int age, int currentLevel, Long idPlan, boolean statusPayment, String imageurl, String publicid) {
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.currentLevel = currentLevel;
        this.idPlan = idPlan;
        this.statusPayment = statusPayment;
        this.imageurl = imageurl;
        this.publicid = publicid;
    }

    /**
     *     id ?: number,
     *     username : string,
     *     name ?: string,
     *     surname ?: string,
     *     age ?: number,
     *     currentLevel : number,
     *     idPlan : number,
     *     statusPayment : boolean,
     *     image ?: string
     */
}
