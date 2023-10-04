package kz.t4jgat.DAO;

import kz.t4jgat.Models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
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


}
