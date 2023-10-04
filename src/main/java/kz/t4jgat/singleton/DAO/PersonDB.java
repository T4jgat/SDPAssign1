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

    public void showPeople() {
        System.out.println("Name\tBank_Account_ID\t Card_number");
        System.out.println("------------------------------------");
        for (int i = 0; i < people.size(); i++){
            Person person = people.get(i);
            System.out.println(person.getName() + "\t" + person.getBankAccoutntId() + "\t\t\t\t " + person.getCardNumber());
        }
    }

    public void saveByCard(String cardNumber, String name) {
        instance.people.add(new Person(cardNumber, name));
    }
    public void saveByQR(int bankAccountId, String name) {
        instance.people.add(new Person(bankAccountId, name));
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
