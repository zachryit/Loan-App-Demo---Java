package com.loanapp;

public class LoanApp {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        LoanService loanService = new LoanService();
        LoanApplication application = loanService.submitApplication("applicant@example.com", 5000.0);

        System.out.println("Login success: " + authService.login("demo", "password123"));
        System.out.println("Loan created for " + application.getEmail());
        loanService.approveLoan(application);
        System.out.println("Approved: " + application.isApproved());
    }
}
