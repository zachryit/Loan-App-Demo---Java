package com.loanapp;

public class LoanApplication {
    private final String applicantEmail;
    private final double amount;
    private boolean approved;

    public LoanApplication(String applicantEmail, double amount) {
        this.applicantEmail = applicantEmail;
        this.amount = amount;
        this.approved = false;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
    }
}
