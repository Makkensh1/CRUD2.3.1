package com.test.services;

import com.test.model.User;

public interface UserService {
    User finByEmail(String email);
}
