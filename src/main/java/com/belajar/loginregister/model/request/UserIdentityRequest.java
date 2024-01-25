package com.belajar.loginregister.model.request;

import com.belajar.loginregister.entity.UserCredential;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserIdentityRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private UserCredential userCredential;
}
