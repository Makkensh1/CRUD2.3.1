package com.test.security;

public interface SecurityService {

    String findLoggedInUserName();

    void autoLogin(String name, String password);

    String findLoggedInEmployeeName();
}
