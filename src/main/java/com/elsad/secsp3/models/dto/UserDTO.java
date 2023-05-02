package com.elsad.secsp3.models.dto;

import com.elsad.secsp3.models.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private String username;

    private Set<Role> roles;
}
