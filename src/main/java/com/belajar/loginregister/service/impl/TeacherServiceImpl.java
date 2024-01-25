package com.belajar.loginregister.service.impl;

import com.belajar.loginregister.entity.Teacher;
import com.belajar.loginregister.model.request.UserIdentityRequest;
import com.belajar.loginregister.repository.TeacherRepository;
import com.belajar.loginregister.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(UserIdentityRequest request) {
        Teacher buildTeacher = Teacher.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .build();
        teacherRepository.save(buildTeacher);
    }
}
