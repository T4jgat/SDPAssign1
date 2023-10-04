package kz.t4jgat.strategy;

import kz.t4jgat.singleton.DAO.PersonDB;
import kz.t4jgat.singleton.Models.Person;

import java.math.BigInteger;

public class CardPayment implements PaymentStrategy{
    PersonDB personDB = PersonDB.getInstance();
    PaymentProcessor paymentProcessor;
    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
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
