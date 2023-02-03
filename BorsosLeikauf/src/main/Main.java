package main;

import utils.DBHelper;

public class Main {

    private static Main instance;

    public static void main(String[] args) {
        DBHelper.createConnection("jdbc:derby://localhost:1527/B_Uebung", "B_Uebung", "B_Uebung");
    }
}