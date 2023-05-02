package com.elsad.secsp3.service;

import com.elsad.secsp3.models.dto.caching.UserCache;
import com.elsad.secsp3.models.entity.User;
import com.elsad.secsp3.repository.UserRepository;
import com.elsad.secsp3.repository.redis.CachedUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final CachedUserRepository cachedUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserCache> byId = cachedUserRepository.findById(username);

        if (byId.isPresent()) {
            return byId.get().getValue();
        }


        User user =userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User : " + username + "not found!");
        }

        UserCache userCache = new UserCache(username,user);
        cachedUserRepository.save(userCache);
        return user;
    }
}
