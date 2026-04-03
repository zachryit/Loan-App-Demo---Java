package com.loanapp;

public class LoanApp {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        LoanService loanService = new LoanService();
        OtpService otpService = new OtpService();

        System.out.println("Login success: " + authService.login("demo", "password123"));

        LoanApplication application = loanService.submitApplication("applicant@example.com", 5000.0);
        System.out.println("Application ID: " + application.getApplicationId());
        System.out.println("Monthly repayment: " + loanService.calculateRepayment(application.getAmount(), 10));

        otpService.issueResetToken(application.getApplicantEmail());
        System.out.println("Reset token valid: " + otpService.isResetTokenValid(application.getApplicantEmail()));

        loanService.approveLoan(application);
        System.out.println("Approved: " + application.isApproved());
    }
}
