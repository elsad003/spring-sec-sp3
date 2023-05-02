package com.elsad.secsp3.api;

import com.elsad.secsp3.models.entity.User;
import com.elsad.secsp3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public User user(@AuthenticationPrincipal User user){
        return user;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public User admin(@AuthenticationPrincipal User user){
        return user;
    }

    @PreAuthorize("hasRole('USER') and hasRole('ADMIN')")
    @GetMapping("/all")
    public User all(@AuthenticationPrincipal User user){
        return user;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/one")
    public User one(@AuthenticationPrincipal User user){
        return user;
    }


}
