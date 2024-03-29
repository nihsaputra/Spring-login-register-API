package com.belajar.loginregister.model.request;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;

}
