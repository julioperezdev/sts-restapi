package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "QUESTION_TYPE")
public class QuestionType {

    @Id
    public Long id;

    private Long idQuestion;

    private Long idTestType;

    public QuestionType(){}

    public QuestionType(Long id, Long idQuestion, Long idTestType) {
        this.id = id;
        this.idQuestion = idQuestion;
        this.idTestType = idTestType;
    }

    public QuestionType(Long idQuestion, Long idTestType) {
        this.idQuestion = idQuestion;
        this.idTestType = idTestType;
    }

    /**
     *     id ?: number,
     *     idQuestion : number,
     *     idTestType : number
     */
}
