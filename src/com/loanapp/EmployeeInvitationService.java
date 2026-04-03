package com.loanapp;

import java.util.HashSet;
import java.util.Set;

public class EmployeeInvitationService {
    private final Set<String> invitedEmployees = new HashSet<>();

    public boolean invite(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }

        return invitedEmployees.add(email.toLowerCase());
    }
}
