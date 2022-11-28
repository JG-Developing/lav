package com.project.lav.application.data.entity;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "\"user\"")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String position;
    private String passwordSalt;
    private String passwordHash;

    public User(){};

    @Autowired
    public User(String username, String password, String position){
        this.username = username;
        this.password = password;
        this.position = position;
        this.passwordSalt = RandomStringUtils.random(32);
        this.passwordHash = DigestUtils.sha1Hex(password + passwordSalt);
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.position = "Guest";
        this.passwordSalt = RandomStringUtils.random(32);
        this.passwordHash = DigestUtils.sha1Hex(password + passwordSalt);
    }

    public Long getId() {
        return this.id;
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

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean checkPassword(String password){
        return DigestUtils.sha1Hex(password + passwordSalt).equals(passwordHash);
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, username='%s', password='%s', position='%s', passwordSalt='%s',passwordHash='%s']", 
                id, username, password, position, passwordHash, passwordSalt);
    }
}
