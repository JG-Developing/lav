package com.project.lav.application.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.lav.application.data.entity.user;

@Repository
public interface userRepository extends JpaRepository<user, Integer> {
    user getByUsername(String username);
}
