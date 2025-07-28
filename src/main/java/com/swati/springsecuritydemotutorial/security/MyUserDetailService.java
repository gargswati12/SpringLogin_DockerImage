package com.swati.springsecuritydemotutorial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swati.springsecuritydemotutorial.model.AllUsers;


@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    private com.swati.springsecuritydemotutorial.repository.AllUsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AllUsers user = repository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .roles(user.getRole())
        .build();
    }
}
