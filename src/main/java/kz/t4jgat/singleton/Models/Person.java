package kz.t4jgat.singleton.Models;

import java.math.BigInteger;

public class Person {
    private int bankAccoutntId;
    private String cardNumber;

    private String name;

    public Person(int bankAccoutntId, String cardNumber, String name) {
        this.bankAccoutntId = bankAccoutntId;
        this.cardNumber = cardNumber;
        this.name = name;
    }

    public Person(int bankAccoutntId) {
        this.name = null;
        this.cardNumber = null;
        this.bankAccoutntId = bankAccoutntId;
    }

    public Person(String cardNumber) {
        this.cardNumber = cardNumber;
        this.name = null;
        this.bankAccoutntId = 0;
    }

    public int getBankAccoutntId() {
        return bankAccoutntId;
    }

    public void setBankAccoutntId(int bankAccoutntId) {
        this.bankAccoutntId = bankAccoutntId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
