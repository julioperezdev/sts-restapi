package com.spanishTongueSound.sts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "userid")
    private Long userId;

    private String username;

    private String password;

    private String email;

    private Date created;

    private boolean enable;

    public User(){}

    public User(Long userId, String username, String password, String email, Date created, boolean enable) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created = created;
        this.enable = enable;
    }

    public User(String username, String password, String email, Date created, boolean enable) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.created = created;
        this.enable = enable;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}