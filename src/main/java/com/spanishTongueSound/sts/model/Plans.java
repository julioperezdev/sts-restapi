package com.spanishTongueSound.sts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "PLANS")
public class Plans {

    @Id
    private Long id;

    private String description;

    private Long price;

    public Plans(){}

    public Plans(Long id, String description, Long price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Plans(String description, Long price) {
        this.description = description;
        this.price = price;
    }

    /**
     *      id ?: number,
     *      description : string,
     *      price: number
     */
}
