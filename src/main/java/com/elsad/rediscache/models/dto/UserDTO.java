package com.elsad.rediscache.models.dto;

import com.elsad.rediscache.models.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private String username;

    private Set<Role> roles;
}
