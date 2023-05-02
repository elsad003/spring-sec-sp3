package com.elsad.rediscache.service;

import com.elsad.rediscache.models.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getByUsername(String username);


}
