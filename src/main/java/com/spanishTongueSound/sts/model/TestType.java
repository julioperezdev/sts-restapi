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
@Table(name = "TEST_TYPE")
public class TestType {

    @Id
    private Long id;

    @Column(name = "contextName")
    private String contextName;

    public TestType(){}

    public TestType(Long id, String contextName) {
        this.id = id;
        this.contextName = contextName;
    }

    public TestType(String contextName) {
        this.contextName = contextName;
    }

    /**
     *     id ?: number,
     *     contextName : string
     */
}
