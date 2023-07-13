package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.example.DataSourceFactory.getNewConnection;

public class Main {
    public static void printList(List<String> list) {
        for (String ls : list) {
            System.out.println(ls);
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection connection = getNewConnection();
        Queries queries = new Queries();

        List<String> names = queries.getPersonsFullNames(connection);
        if (!names.isEmpty()) {
            System.out.println("Fullnames from table Person:");
            printList(names);
            System.out.println("\nBanks names:");
            names = queries.getBanksNames(connection);
            printList(names);
            queries.setBanksNames(connection, "2");
            System.out.println("\nChanged banks names:");
            names = queries.getBanksNames(connection);
            printList(names);
        }
    }
}