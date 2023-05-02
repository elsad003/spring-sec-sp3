package com.elsad.secsp3.api;


import com.elsad.secsp3.config.JwtUtils;
import com.elsad.secsp3.models.dto.AuthenticationDTO;
import com.elsad.secsp3.models.entity.Role;
import com.elsad.secsp3.models.entity.User;
import com.elsad.secsp3.repository.RoleRepository;
import com.elsad.secsp3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthApi {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/login")
    public ResponseEntity<String> getToken(@RequestBody AuthenticationDTO registerDto){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerDto.getUsername(), registerDto.getPassword()));

        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/signup")
    @Transactional
    public String register(@RequestBody AuthenticationDTO registerDto){

        Set<Role> roles = Set.of(roleRepository.findByName("ROLE_USER"));

        User newUser = new User(null,
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                true,
                roles);

        userRepository.save(newUser);

        return "saved";
    }

}
