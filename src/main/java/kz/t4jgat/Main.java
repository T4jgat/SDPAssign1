package kz.t4jgat;

import kz.t4jgat.singleton.DAO.PersonDB;
import kz.t4jgat.singleton.Models.Person;
import kz.t4jgat.strategy.PaymentProcessor;
import kz.t4jgat.strategy.ShopppingCart;

public class Main {
    public static void main(String[] args) {

        PersonDB personDB = PersonDB.getInstance();
        PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();

        ShopppingCart shopppingCart = new ShopppingCart(paymentProcessor);
        shopppingCart.shoppingProcess();


    }
}