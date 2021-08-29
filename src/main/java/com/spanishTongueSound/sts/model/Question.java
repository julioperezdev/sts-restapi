package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    private Long id;

    private String question;

    private Long idLevel;

    public Question(){}

    public Question(Long id, String question, Long idLevel) {
        this.id = id;
        this.question = question;
        this.idLevel = idLevel;
    }

    public Question(String question, Long idLevel) {
        this.question = question;
        this.idLevel = idLevel;
    }

    /**
     *     id ?: number,
     *     idLevel : number,
     *     question : string
     */
}
