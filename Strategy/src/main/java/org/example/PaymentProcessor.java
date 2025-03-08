package org.example;

public class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executar(double amount) {
        strategy.processPayment(amount);
    }
}
