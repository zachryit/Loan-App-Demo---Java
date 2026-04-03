package com.loanapp;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class OtpService {
    private final Map<String, Instant> resetTokenExpiry = new HashMap<>();

    public void issueResetToken(String email) {
        resetTokenExpiry.put(email, Instant.now().plusSeconds(900));
    }

    public boolean isResetTokenValid(String email) {
        Instant expiry = resetTokenExpiry.get(email);
        return expiry != null && Instant.now().isBefore(expiry);
    }
}
