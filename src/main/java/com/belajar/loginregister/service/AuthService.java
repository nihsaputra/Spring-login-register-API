package com.belajar.loginregister.service;

import com.belajar.loginregister.entity.UserCredential;
import com.belajar.loginregister.model.request.RegisterRequest;
import com.belajar.loginregister.model.response.RegisterResponse;

public interface AuthService {
    RegisterResponse registerAdmin(RegisterRequest request);
    RegisterResponse registerTeacher(RegisterRequest request);
    RegisterResponse registerStudent(RegisterRequest request);
}
