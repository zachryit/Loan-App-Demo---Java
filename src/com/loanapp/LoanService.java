package com.loanapp;

public class LoanService {
    private final PayrollDeductionService payrollDeductionService;

    public LoanService(PayrollDeductionService payrollDeductionService) {
        this.payrollDeductionService = payrollDeductionService;
    }

    public LoanApplication submitApplication(String email, double amount) {
        return new LoanApplication(email, amount);
    }

    public void approveLoan(LoanApplication application) {
        application.approve();
    }

    public double calculateRepayment(double amount, int months) {
        return payrollDeductionService.calculateMonthlyDeduction(amount, months);
    }
}
