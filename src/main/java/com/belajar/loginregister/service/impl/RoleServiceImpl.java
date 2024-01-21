package com.belajar.loginregister.service.impl;

import com.belajar.loginregister.constan.ERole;
import com.belajar.loginregister.entity.Role;
import com.belajar.loginregister.repository.RoleRepository;
import com.belajar.loginregister.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role getOrSave(ERole role) {
        Optional<Role> optionalRole = roleRepository.findByRole(role);
        if (optionalRole.isPresent()) return optionalRole.get();
        return roleRepository.save(Role.builder()
               .role(role)
               .build());
    }
}
