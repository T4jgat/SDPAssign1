package kz.t4jgat.DAO;

import kz.t4jgat.Models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;
    private static volatile PersonDAO instance;
    private static Object mutex = new Object();


    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "John"));
        people.add(new Person(++PEOPLE_COUNT, "Greg"));
        people.add(new Person(++PEOPLE_COUNT, "Sam"));
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Eliot"));
    }

    public static PersonDAO getInstance() {
            PersonDAO result = instance;
            if (result == null) {
                synchronized (mutex) {
                    result = instance;
                    if (result == null)
                        instance = result = new PersonDAO();
                }
            }
            return result;
    }
}
