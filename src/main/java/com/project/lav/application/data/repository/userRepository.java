package com.project.lav.application.data.repository;

import com.project.lav.application.data.entity.User;
//import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUsername(String username);
}
