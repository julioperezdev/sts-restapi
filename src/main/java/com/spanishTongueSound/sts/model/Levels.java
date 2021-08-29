package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "LEVELS")
public class Levels {

    @Id
    private Long id;

    private int numberLevel;

    public Levels(){};

    public Levels(Long id, int numberLevel) {
        this.id = id;
        this.numberLevel = numberLevel;
    }

    public Levels(int numberLevel) {
        this.numberLevel = numberLevel;
    }

    /**
     *     id ?: number,
     *     nameLevel : number,
     */
}
