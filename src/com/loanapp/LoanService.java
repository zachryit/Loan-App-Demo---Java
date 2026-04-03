package com.loanapp;

public class LoanService {
    public LoanApplication submitApplication(String email, double amount) {
        return new LoanApplication(email, amount);
    }

    public void approveLoan(LoanApplication application) {
        application.approve();
    }

    public double calculateRepayment(double amount, int months) {
        if (months <= 0) {
            throw new IllegalArgumentException("Months must be greater than zero");
        }

        return amount / months;
    }
}
