package kz.t4jgat.singleton.DAO;

import kz.t4jgat.singleton.Models.Person;

import java.util.ArrayList;
import java.util.List;

// Singleton class
public class PersonDB {
    private static volatile PersonDB instance;
    private static Object mutex = new Object();

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "John"));
        people.add(new Person(++PEOPLE_COUNT, "Greg"));
        people.add(new Person(++PEOPLE_COUNT, "Sam"));
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Eliot"));
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
