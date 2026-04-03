package com.loanapp;

public class LoanApp {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        NotificationService notificationService = new NotificationService();
        PayrollDeductionService payrollDeductionService = new PayrollDeductionService();
        LoanService loanService = new LoanService(notificationService, payrollDeductionService);
        LoanApplication application = loanService.submitApplication("applicant@example.com", 5000.0);

        System.out.println("Login success: " + authService.login("demo", "password123"));
        System.out.println("Loan created for " + application.getEmail());
        System.out.println("Monthly repayment: " + loanService.calculateRepayment(application.getAmount(), 10));
        authService.issueResetToken(application.getEmail());
        System.out.println("Reset token valid: " + authService.isResetTokenValid(application.getEmail()));
        loanService.approveLoan(application);
        System.out.println("Approved: " + application.isApproved());
    }
}
