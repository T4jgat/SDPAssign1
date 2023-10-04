package kz.t4jgat.strategy;

import kz.t4jgat.singleton.DAO.PersonDB;

public class PaymentProcessor {

    private static PaymentProcessor instance;
    private PaymentStrategy paymentStrategy;
    private static Object mutex = new Object();

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.processPayment(amount);
    }

    public static PaymentProcessor getInstance() {
        PaymentProcessor result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new PaymentProcessor();
            }
        }
        return result;
    }

}
