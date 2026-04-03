package com.loanapp;

public class LoanService {
    public LoanApplication submitApplication(String email, double amount) {
        return new LoanApplication(email, amount);
    }
}
