package kz.t4jgat;

import kz.t4jgat.singleton.DAO.PersonDB;

public class Main {
    public static void main(String[] args) {

        PersonDB dao1 = PersonDB.getInstance();
        PersonDB dao2 = PersonDB.getInstance();

        PersonDB dao3 = new PersonDB();
        PersonDB dao4 = new PersonDB();

        System.out.println(dao1 == dao2);
        System.out.println(dao3 == dao4);
    }
}