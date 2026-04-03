package com.loanapp;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static final long RESET_TOKEN_TTL_SECONDS = 300;
    private final Map<String, Instant> resetTokenExpiry = new HashMap<>();

    public boolean login(String username, String password) {
        if (username == null || username.isBlank()) {
            return false;
        }

        if (password == null || password.isBlank()) {
            return false;
        }

        return "password123".equals(password);
    }

    public void issueResetToken(String email) {
        resetTokenExpiry.put(email, Instant.now().plusSeconds(RESET_TOKEN_TTL_SECONDS));
    }

    public boolean isResetTokenValid(String email) {
        Instant expiry = resetTokenExpiry.get(email);
        return expiry != null && Instant.now().isBefore(expiry);
    }
}
