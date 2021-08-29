package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "PRESENTATION")
public class Presentation {

    @Id
    private Long id;

    private int points;

    @Column(name = "datePresentation")
    private Date datePresentation;

    private boolean approved;

    @Column(name = "stepOpportunity")
    private int stepOpportunity;

    @Column(name = "idTest")
    private Long idTest;

    public Presentation(){}

    public Presentation(Long id, int points, Date datePresentation, boolean approved, int stepOpportunity, Long idTest) {
        this.id = id;
        this.points = points;
        this.datePresentation = datePresentation;
        this.approved = approved;
        this.stepOpportunity = stepOpportunity;
        this.idTest = idTest;
    }

    public Presentation(int points, Date datePresentation, boolean approved, int stepOpportunity, Long idTest) {
        this.points = points;
        this.datePresentation = datePresentation;
        this.approved = approved;
        this.stepOpportunity = stepOpportunity;
        this.idTest = idTest;
    }

    /**
     *     id ?: number,
     *     points: number,
     *     datePresentation: Date,
     *     approved: boolean,
     *     stepOpportunity : number,
     *     idTest : number
     */
}
