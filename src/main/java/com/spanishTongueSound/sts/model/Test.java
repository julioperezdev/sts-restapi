package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "Test")
public class Test {

    @Id
    private Long id;

    @Column(name = "dateInit")
    private Date dateInit;

    @Column(name = "idStudent")
    private Long idStudent;

    @Column(name = "idTestType")
    private Long idTestType;

    public Test(){}

    public Test(Long id, Date dateInit, Long idStudent, Long idTestType) {
        this.id = id;
        this.dateInit = dateInit;
        this.idStudent = idStudent;
        this.idTestType = idTestType;
    }

    public Test(Date dateInit, Long idStudent, Long idTestType) {
        this.dateInit = dateInit;
        this.idStudent = idStudent;
        this.idTestType = idTestType;
    }

    /**
     *     idTest: number,
     *     dateInit : Date,
     *     idStudent: number,
     *     idTestType: number
     */
}
