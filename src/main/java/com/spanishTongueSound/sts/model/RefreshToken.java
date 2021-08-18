package com.spanishTongueSound.sts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "refreshtoken")
public class RefreshToken {
    @Id
    private Long id;
    private String token;
    @Column(name = "createddate")
    private Instant createdDate;
}