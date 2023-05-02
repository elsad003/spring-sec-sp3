package com.elsad.secsp3.repository;

import com.elsad.secsp3.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
