package com.elsad.rediscache.service;

import com.elsad.rediscache.models.dto.caching.UserCache;
import com.elsad.rediscache.models.entity.User;
import com.elsad.rediscache.repository.UserRepository;
import com.elsad.rediscache.repository.redis.CachedUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("userCache2")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User : " + username + "not found!");
        }

        return user;
    }
}
