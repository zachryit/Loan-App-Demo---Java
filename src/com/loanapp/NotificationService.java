package com.loanapp;

public class NotificationService {
    public void send(String email, String message) {
        System.out.println("Sending email to " + email + ": " + message);
    }
}
