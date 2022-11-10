package com.project.lav;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "\"user\"")
@Entity
public class user {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String passwordSalt;
    private String passwordHash;

    public user(){};

    @Autowired
    public user(String username, String password){
        this.username = username;
        this.password = password;
        this.passwordSalt = RandomStringUtils.random(32);
        this.passwordHash = DigestUtils.sha1Hex(password + passwordSalt);

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

    public Boolean checkPassword(String password){
        return DigestUtils.sha1Hex(password + passwordSalt).equals(passwordHash);
    }
}
