package kz.t4jgat.strategy;

public class CardPayment implements PaymentStrategy{
    private String cardNumber;
    private String name;

    public CardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing card payment of $" + amount+ "...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
