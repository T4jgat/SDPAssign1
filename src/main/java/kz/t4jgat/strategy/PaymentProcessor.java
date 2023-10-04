package kz.t4jgat.strategy;

import com.sun.source.tree.PackageTree;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}
