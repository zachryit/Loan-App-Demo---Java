package com.loanapp;

public class LoanApplication {
    private static int sequence = 1000;

    private final String applicationId;
    private final String applicantEmail;
    private final double amount;
    private boolean approved;

    public LoanApplication(String applicantEmail, double amount) {
        this.applicationId = "LN-" + sequence++;
        this.applicantEmail = applicantEmail;
        this.amount = amount;
        this.approved = false;
    }

    public String getApplicationId() {
        return applicationId;
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
