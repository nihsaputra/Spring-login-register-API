package com.belajar.loginregister.service;

import com.belajar.loginregister.entity.Admin;
import com.belajar.loginregister.model.request.UserIdentityRequest;

public interface AdminService {
    void create(UserIdentityRequest request);
}
