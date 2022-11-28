package com.project.lav.application.data.repository;

import com.project.lav.application.data.entity.user;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface userRepository extends JpaRepository<user, Integer> {
    user getByUsername(String username);
    List<user> findByPosition(String position);
}
