package com.belajar.loginregister.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtClaim {
    private String userId;
    private List<String> roles;
}
