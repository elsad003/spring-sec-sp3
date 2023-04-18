package com.elsad.secsp3.service;

import com.elsad.secsp3.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getByUsername(String username);


}
