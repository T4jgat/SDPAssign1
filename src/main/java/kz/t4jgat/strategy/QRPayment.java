package kz.t4jgat.strategy;

import kz.t4jgat.singleton.DAO.PersonDB;

public class QRPayment implements PaymentStrategy{
    PersonDB personDAO = PersonDB.getInstance();

    private int bankAccountId;

    public QRPayment(int bankAccountId, String name) {
        this.personDAO.saveByQR(bankAccountId, name);
        this.bankAccountId = bankAccountId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing QR payment of $" + amount);
    }
}
