package com.loanapp;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class OtpService {
    private static final long RESET_TOKEN_TTL_SECONDS = 300;
    private final Map<String, Instant> resetTokenExpiry = new HashMap<>();

    public void issueResetToken(String email) {
        resetTokenExpiry.put(email, Instant.now().plusSeconds(RESET_TOKEN_TTL_SECONDS));
    }

    public boolean isResetTokenValid(String email) {
        Instant expiry = resetTokenExpiry.get(email);
        return expiry != null && Instant.now().isBefore(expiry);
    }
}
