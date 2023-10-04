package kz.t4jgat.singleton.DAO;

import kz.t4jgat.singleton.Models.Person;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Singleton class
public class PersonDB {
    private static volatile PersonDB instance;
    private static Object mutex = new Object();

    private List<Person> people;

    {
        people = new ArrayList<>();
    }

    public String show() {

    }

    public void saveByCard(String cardNumber) {
        instance.people.add(new Person(cardNumber));
    }
    public void saveByQR(int bankAccountId) {
        instance.people.add(new Person(bankAccountId));
    }

    public static PersonDB getInstance() {
        PersonDB result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new PersonDB();
            }
        }
        return result;
    }
}
