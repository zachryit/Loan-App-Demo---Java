package com.loanapp;

public class LoanApp {
    public static void main(String[] args) {
        LoanService loanService = new LoanService();
        LoanApplication application = loanService.submitApplication("applicant@example.com", 5000.0);

        System.out.println("Loan created for " + application.getEmail());
    }
}
