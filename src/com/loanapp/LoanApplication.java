package com.loanapp;

public class LoanApplication {
    private static int sequence = 1000;

    private final String applicationId;
    private final String email;
    private final double amount;
    private boolean approved;

    public LoanApplication(String email, double amount) {
        this.applicationId = "LN-" + sequence++;
        this.email = email;
        this.amount = amount;
        this.approved = false;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getEmail() {
        return email;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        approved = true;
    }
}
