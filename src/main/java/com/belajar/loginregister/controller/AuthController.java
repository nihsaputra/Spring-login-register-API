package com.belajar.loginregister.controller;

import com.belajar.loginregister.model.request.LoginRequest;
import com.belajar.loginregister.model.request.RegisterRequest;
import com.belajar.loginregister.model.response.RegisterResponse;
import com.belajar.loginregister.model.response.WebResponse;
import com.belajar.loginregister.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {
    private final AuthService authService;

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping(path = "/register/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest request){
        RegisterResponse registerResponse = authService.registerAdmin(request);
        WebResponse<RegisterResponse> response = WebResponse.<RegisterResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("successfully register")
                .data(registerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/register/teacher")
    public ResponseEntity<?> registerTeacher(@RequestBody RegisterRequest request){
        RegisterResponse registerResponse = authService.registerTeacher(request);
        WebResponse<RegisterResponse> response = WebResponse.<RegisterResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("successfully register")
                .data(registerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/register/student")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterRequest request){
        RegisterResponse registerResponse = authService.registerStudent(request);
        WebResponse<RegisterResponse> response = WebResponse.<RegisterResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("successfully register")
                .data(registerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        String login = authService.login(request);
        WebResponse<String> response = WebResponse.<String>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("successfully login")
                .data(login)
                .build();
        return ResponseEntity.ok(response);
    }
}
