package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "STUDENT_TEACHER")
public class StudentTeacher {

    @Id
    private Long id;

    private Long idStudent;

    private Long idTeacher;

    public StudentTeacher(){}

    public StudentTeacher(Long id, Long idStudent, Long idTeacher) {
        this.id = id;
        this.idStudent = idStudent;
        this.idTeacher = idTeacher;
    }

    public StudentTeacher(Long idStudent, Long idTeacher) {
        this.idStudent = idStudent;
        this.idTeacher = idTeacher;
    }

    /**
     *     id ?: number,
     *     idStudent : number,
     *     idTeacher : number,
     */
}
