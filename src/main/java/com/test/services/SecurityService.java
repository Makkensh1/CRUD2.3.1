package com.test.services;

public interface SecurityService {

    String  findLoggedUsername();

    void AutoLogin (String username, String password);
}
