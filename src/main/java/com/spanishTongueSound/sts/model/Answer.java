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
@Table(name = "ANSWER")
public class Answer {

    @Id
    private Long id;

    private String answer;

    @Column(name="idQuestion")
    private Long idQuestion;

    private boolean correct;

    public Answer(){}

    public Answer(Long id, String answer, Long idQuestion, boolean correct) {
        this.id = id;
        this.answer = answer;
        this.idQuestion = idQuestion;
        this.correct = correct;
    }

    public Answer(String answer, Long idQuestion, boolean correct) {
        this.answer = answer;
        this.idQuestion = idQuestion;
        this.correct = correct;
    }

    /**
     *     id ?: number,
     *     answer : string,
     *     idQuestion : number,
     *     correct : boolean
     */
}
