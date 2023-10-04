package kz.t4jgat;

import kz.t4jgat.DAO.PersonDAO;
import kz.t4jgat.Models.Person;

public class Main {
    public static void main(String[] args) {

        PersonDAO dao1 = PersonDAO.getInstance();
        PersonDAO dao2 = PersonDAO.getInstance();

        PersonDAO dao3 = new PersonDAO();
        PersonDAO dao4 = new PersonDAO();

        System.out.println(dao1 == dao2);
        System.out.println(dao3 == dao4);
    }
}