package kz.t4jgat.strategy;

public class QRPayment implements PaymentStrategy{
    private String bankAccountId;

    public QRPayment(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing QR payment of $" + amount);
    }
}
