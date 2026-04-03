package com.loanapp;

public class LoanService {
    private final NotificationService notificationService;

    public LoanService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public LoanApplication submitApplication(String email, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }

        return new LoanApplication(email, amount);
    }

    public double calculateRepayment(double amount, int months) {
        if (months <= 0) {
            throw new IllegalArgumentException("Months must be greater than zero");
        }

        return amount / months;
    }

    public void approveLoan(LoanApplication application) {
        application.approve();
        notificationService.send(application.getApplicantEmail(), "Your loan has been approved.");
    }
}
