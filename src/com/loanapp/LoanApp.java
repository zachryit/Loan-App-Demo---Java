package com.loanapp;

public class LoanApp {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        NotificationService notificationService = new NotificationService();
        PayrollDeductionService payrollDeductionService = new PayrollDeductionService();
        LoanService loanService = new LoanService(notificationService, payrollDeductionService);
        OtpService otpService = new OtpService();
        EmployeeInvitationService employeeInvitationService = new EmployeeInvitationService();

        System.out.println("Login success: " + authService.login("demo", "password123"));
        System.out.println("Employee invited: " + employeeInvitationService.invite("staff@company.com"));

        LoanApplication application = loanService.submitApplication("applicant@example.com", 5000.0);
        System.out.println("Application ID: " + application.getApplicationId());
        System.out.println("Monthly repayment: " + loanService.calculateRepayment(application.getAmount(), 10));

        otpService.issueResetToken(application.getApplicantEmail());
        System.out.println("Reset token valid: " + otpService.isResetTokenValid(application.getApplicantEmail()));

        loanService.approveLoan(application);
        System.out.println("Approved: " + application.isApproved());
    }
}
