package com.belajar.loginregister.service.impl;

import com.belajar.loginregister.entity.Student;
import com.belajar.loginregister.model.request.UserIdentityRequest;
import com.belajar.loginregister.repository.StudentRepository;
import com.belajar.loginregister.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(UserIdentityRequest request) {
        Student buildStudent = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .userCredential(request.getUserCredential())
                .build();
        studentRepository.save(buildStudent);
    }
}
