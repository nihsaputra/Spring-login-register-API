package com.belajar.loginregister.service.impl;

import com.belajar.loginregister.entity.Admin;
import com.belajar.loginregister.model.request.UserIdentityRequest;
import com.belajar.loginregister.repository.AdminRepository;
import com.belajar.loginregister.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(UserIdentityRequest request) {
        Admin buildAdmin = Admin.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .userCredential(request.getUserCredential())
                .build();
        adminRepository.save(buildAdmin);
    }
}
