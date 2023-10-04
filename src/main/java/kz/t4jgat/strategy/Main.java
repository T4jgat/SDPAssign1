package kz.t4jgat.strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        ShopppingCart shopppingCart = new ShopppingCart(paymentProcessor);

        shopppingCart.shoppingProcess();
    }
}
