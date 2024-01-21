package com.belajar.loginregister.service;

import com.belajar.loginregister.constan.ERole;
import com.belajar.loginregister.entity.Role;

public interface RoleService {
    Role getOrSave(ERole role);
}
