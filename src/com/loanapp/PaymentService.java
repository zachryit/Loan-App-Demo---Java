package com.loanapp;

import java.util.HashSet;
import java.util.Set;

public class PaymentService {
    private final Set<String> processedRetries = new HashSet<>();

    public boolean retryPayment(String paymentReference) {
        if (paymentReference == null || paymentReference.isBlank()) {
            return false;
        }

        return processedRetries.add(paymentReference);
    }
}
