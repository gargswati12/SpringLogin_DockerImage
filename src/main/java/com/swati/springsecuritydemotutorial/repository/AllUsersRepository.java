package com.swati.springsecuritydemotutorial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swati.springsecuritydemotutorial.model.AllUsers;

public interface AllUsersRepository extends JpaRepository <AllUsers, Long> {
    Optional<AllUsers> findByUsername (String username);
}
