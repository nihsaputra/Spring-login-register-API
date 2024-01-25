package com.belajar.loginregister.service;

import com.belajar.loginregister.entity.UserCredential;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserCredential loadUserById(String id);
}
