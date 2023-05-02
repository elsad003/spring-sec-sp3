package com.elsad.rediscache.service;

import com.elsad.rediscache.models.dto.caching.UserCache;
import com.elsad.rediscache.models.entity.User;
import com.elsad.rediscache.repository.UserRepository;
import com.elsad.rediscache.repository.redis.CachedUserRepository;
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
