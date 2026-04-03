package com.loanapp;

public class LoanService {
    private final NotificationService notificationService;
    private final PayrollDeductionService payrollDeductionService;

    public LoanService(NotificationService notificationService, PayrollDeductionService payrollDeductionService) {
        this.notificationService = notificationService;
        this.payrollDeductionService = payrollDeductionService;
    }

    public LoanApplication submitApplication(String email, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }

        return new LoanApplication(email, amount);
    }

    public double calculateRepayment(double amount, int months) {
        return payrollDeductionService.calculateMonthlyDeduction(amount, months);
    }

    public void approveLoan(LoanApplication application) {
        application.approve();
        notificationService.send(application.getApplicantEmail(), "Your loan has been approved.");
    }
}
