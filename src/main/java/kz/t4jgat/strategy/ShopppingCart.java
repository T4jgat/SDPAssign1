package kz.t4jgat.strategy;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import kz.t4jgat.strategy.Product;

public class ShopppingCart {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private List<Product> products = new ArrayList<>();
    private PaymentProcessor paymentProcessor;

    public ShopppingCart(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    private void addProduct(String name, double price, int quantity) {
        products.add(new Product(name, price, quantity));
        System.out.println("\n======Product (" + name + ") added!======");
    }

    private double calculatingTotalPrice() {
        double generalSum = 0, qtySum;
        for (int i = 0; i < products.size(); i++) {
             qtySum = products.get(i).getPrice() * products.get(i).getQuantity();
             generalSum = generalSum + qtySum;
        }
        return generalSum;
     }

     private void viewContent() {
         Product product;
         int count = 0;
         System.out.println("\n--------------Shopping cart--------------");
         for (int i = 0; i < products.size(); i++) {
             product = products.get(i);
             System.out.println(++count + "\t"+product.getName()+"\t$"+product.getPrice()+"\t"+product.getQuantity()+"pc.");
         }

         System.out.println("-----------------------------------------");
         System.out.println("Total price: $"+ df.format(calculatingTotalPrice()));
         System.out.println("-----------------------------------------");
     }

    public void shoppingProcess() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        String productName;
        double price;
        int qty;
        String action = "-", name, cardNumber, bankAccountId;

        while (!action.equals("e")) {
            System.out.print("""
                \n[1] Add product
                [2] View the cart's content
                [3] Calculating total price
                [4] Choose payment strategy
                [5] Complete the checkout
                [e] Exit
                >>\s""");

            action = sc.next();
            switch (action) {
                case "1" -> {
                    System.out.print("\nProduct name: ");
                    productName = sc.next();
                    System.out.print("Product price: ");
                    price = sc.nextDouble();
                    System.out.print("Product quantity: ");
                    qty = sc.nextInt();
                    this.addProduct(productName, price, qty);
                }
                case "2" -> this.viewContent();
                case "3" -> System.out.println("Total price: $" + this.calculatingTotalPrice());
                case "4" -> {
                    System.out.print("""
                            \nChoose your payment strategy:
                            [1] Card
                            [2] Cash
                            >>\s
                            """);
                    int selectedStrategy = sc.nextInt();
                    if (selectedStrategy == 1) {
                        System.out.print("Your card number: ");
                        cardNumber = sc.next();
                        System.out.print("Your name: ");
                        name = sc.next();
                        paymentProcessor.setPaymentStrategy(new CardPayment(cardNumber, name));
                    } else {
                        System.out.print("Your bank account ID: ");
                        bankAccountId = sc.next();
                        paymentProcessor.setPaymentStrategy(new QRPayment(bankAccountId));
                    }
                    System.out.println("\n====Your payment method set!====");
                }
                case "5" -> {
                    double totalPrice = calculatingTotalPrice();
                    paymentProcessor.executePayment(totalPrice);
                    System.out.println("Payment in the amount of $" + totalPrice + " has been completed!");
                }
                case "e" -> System.out.println("exit...");
                default -> System.out.println("\nUnexpected value!");
            }
        }
    }

}
