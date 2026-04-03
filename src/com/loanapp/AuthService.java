package com.loanapp;

public class AuthService {
    public boolean login(String username, String password) {
        if (username == null || username.isBlank()) {
            return false;
        }

        return "password123".equals(password);
    }
}
