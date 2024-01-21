package com.belajar.loginregister.repository;

import com.belajar.loginregister.constan.ERole;
import com.belajar.loginregister.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRole(ERole role);
}