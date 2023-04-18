package com.elsad.secsp3.service;

import com.elsad.secsp3.entity.User;
import com.elsad.secsp3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User : " + username + "not found!");
        }
        System.out.println(user);
        return user;
    }
}
