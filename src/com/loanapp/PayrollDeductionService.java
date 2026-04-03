package com.loanapp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayrollDeductionService {
    public double calculateMonthlyDeduction(double amount, int months) {
        if (months <= 0) {
            throw new IllegalArgumentException("Months must be greater than zero");
        }

        return BigDecimal.valueOf(amount)
                .divide(BigDecimal.valueOf(months), 2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
