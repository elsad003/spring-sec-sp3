package com.elsad.secsp3.api;

import com.elsad.secsp3.entity.User;
import com.elsad.secsp3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class TestApi {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public User user(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User byUsername = userRepository.findByUsername(authentication.getName());

        return byUsername;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public User admin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User byUsername = userRepository.findByUsername(authentication.getName());

        return byUsername;
    }

    @PreAuthorize("hasRole('USER') and hasRole('ADMIN')")
    @GetMapping("/all")
    public User all(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User byUsername = userRepository.findByUsername(authentication.getName());

        return byUsername;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/one")
    public User one(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User byUsername = userRepository.findByUsername(authentication.getName());

        return byUsername;
    }


}
