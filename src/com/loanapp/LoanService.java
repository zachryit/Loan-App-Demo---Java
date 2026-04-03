package com.loanapp;

public class LoanService {
    private final NotificationService notificationService;
    private final PayrollDeductionService payrollDeductionService;

    public LoanService(NotificationService notificationService, PayrollDeductionService payrollDeductionService) {
        this.notificationService = notificationService;
        this.payrollDeductionService = payrollDeductionService;
    }

    public LoanApplication submitApplication(String email, double amount) {
        return new LoanApplication(email, amount);
    }

    public void approveLoan(LoanApplication application) {
        application.approve();
        notificationService.send(application.getEmail(), "Your loan has been approved.");
    }

    public double calculateRepayment(double amount, int months) {
        return payrollDeductionService.calculateMonthlyDeduction(amount, months);
    }
}
