package com.belajar.loginregister.service.impl;

import com.belajar.loginregister.constan.ERole;
import com.belajar.loginregister.entity.Role;
import com.belajar.loginregister.entity.UserCredential;
import com.belajar.loginregister.model.request.RegisterRequest;
import com.belajar.loginregister.model.response.RegisterResponse;
import com.belajar.loginregister.repository.UserCredentialRepository;
import com.belajar.loginregister.service.AuthService;
import com.belajar.loginregister.service.RoleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Value("${app.login-register.email}")
    private String email;

    @Value("${app.login-register.passaword}")
    private String password;

    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;



    @PostConstruct
    @Transactional(rollbackFor = Exception.class)
    public void initSuperAdmin(){
        Optional<UserCredential> optionalEmail = userCredentialRepository.findByEmail(email);
        if (optionalEmail.isPresent()) return;

        String hashPassword = passwordEncoder.encode(password);
        Role roleSuperAdmin = roleService.getOrSave(ERole.ROLE_SUPER_ADMIN);
        Role roleAdmin = roleService.getOrSave(ERole.ROLE_ADMIN);
        Role roleStudent = roleService.getOrSave(ERole.ROLE_STUDENT);
        Role roleTeacher = roleService.getOrSave(ERole.ROLE_TEACHER);

        userCredentialRepository.save(
                UserCredential
                        .builder()
                        .email(email)
                        .roles(List.of(roleAdmin,roleSuperAdmin,roleStudent,roleTeacher))
                        .password(hashPassword)
                        .build()
        );
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RegisterResponse registerAdmin(RegisterRequest request) {
        Optional<UserCredential> optionalEmail = userCredentialRepository.findByEmail(request.getEmail());
        if (optionalEmail.isPresent()) throw new ResponseStatusException(HttpStatus.CONFLICT,"email already exist");

        String hashPassword = passwordEncoder.encode(request.getPassword());
        Role roleAdmin = roleService.getOrSave(ERole.ROLE_ADMIN);
        Role roleStudent = roleService.getOrSave(ERole.ROLE_STUDENT);
        Role roleTeacher = roleService.getOrSave(ERole.ROLE_TEACHER);
        UserCredential buildUserCredential = UserCredential.builder()
                .email(request.getEmail())
                .password(hashPassword)
                .roles(List.of(roleAdmin, roleStudent, roleTeacher))
                .build();

        UserCredential userCredential = userCredentialRepository.saveAndFlush(buildUserCredential);
        return RegisterResponse.builder()
                .email(userCredential.getEmail())
                .roles(userCredential.getRoles().stream().map(role -> role.getRole().name()).toList())
                .build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RegisterResponse registerTeacher(RegisterRequest request) {
        Optional<UserCredential> optionalEmail = userCredentialRepository.findByEmail(request.getEmail());
        if (optionalEmail.isPresent()) throw new ResponseStatusException(HttpStatus.CONFLICT,"email already exist");

        String hashPassword = passwordEncoder.encode(request.getPassword());
        Role roleStudent = roleService.getOrSave(ERole.ROLE_STUDENT);
        Role roleTeacher = roleService.getOrSave(ERole.ROLE_TEACHER);
        UserCredential buildUserCredential = UserCredential.builder()
                .email(request.getEmail())
                .password(hashPassword)
                .roles(List.of(roleTeacher,roleStudent))
                .build();

        UserCredential userCredential = userCredentialRepository.saveAndFlush(buildUserCredential);
        return RegisterResponse.builder()
                .email(userCredential.getEmail())
                .roles(userCredential.getRoles().stream().map(role -> role.getRole().name()).toList())
                .build();
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RegisterResponse registerStudent(RegisterRequest request) {
        Optional<UserCredential> optionalEmail = userCredentialRepository.findByEmail(request.getEmail());
        if (optionalEmail.isPresent()) throw new ResponseStatusException(HttpStatus.CONFLICT,"email already exist");

        String hashPassword = passwordEncoder.encode(request.getPassword());
        Role roleStudent = roleService.getOrSave(ERole.ROLE_STUDENT);
        UserCredential buildUserCredential = UserCredential.builder()
                .email(request.getEmail())
                .password(hashPassword)
                .roles(List.of(roleStudent))
                .build();

        UserCredential userCredential = userCredentialRepository.saveAndFlush(buildUserCredential);
        return RegisterResponse.builder()
                .email(userCredential.getEmail())
                .roles(userCredential.getRoles().stream().map(role -> role.getRole().name()).toList())
                .build();
    }

}
