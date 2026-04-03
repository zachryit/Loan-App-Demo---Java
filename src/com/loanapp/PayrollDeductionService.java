package com.loanapp;

public class PayrollDeductionService {
    public double calculateMonthlyDeduction(double amount, int months) {
        if (months <= 0) {
            throw new IllegalArgumentException("Months must be greater than zero");
        }

        return amount / months;
    }
}
