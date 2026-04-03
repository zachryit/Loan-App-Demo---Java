package com.loanapp;

public class LoanApp {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        NotificationService notificationService = new NotificationService();
        PayrollDeductionService payrollDeductionService = new PayrollDeductionService();
        LoanService loanService = new LoanService(notificationService, payrollDeductionService);
        EmployeeInvitationService employeeInvitationService = new EmployeeInvitationService();
        PaymentService paymentService = new PaymentService();

        System.out.println("Login success: " + authService.login("demo", "password123"));
        System.out.println("Employee invited: " + employeeInvitationService.invite("staff@company.com"));
        System.out.println("Payment retry accepted: " + paymentService.retryPayment("PAY-001"));

        LoanApplication application = loanService.submitApplication("applicant@example.com", 5000.0);
        System.out.println("Application ID: " + application.getApplicationId());
        System.out.println("Monthly repayment: " + loanService.calculateRepayment(application.getAmount(), 10));

        authService.issueResetToken(application.getApplicantEmail());
        System.out.println("Reset token valid: " + authService.isResetTokenValid(application.getApplicantEmail()));

        loanService.approveLoan(application);
        System.out.println("Approved: " + application.isApproved());
    }
}
