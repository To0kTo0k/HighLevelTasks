package org.example;

import org.example.daos.Dao;

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
        Dao dao = new Dao();

        List<String> names = dao.getPersonsFullNames(connection);
        if (!names.isEmpty()) {
            System.out.println("Fullnames from table Person:");
            printList(names);
            System.out.println("\nBanks names:");
            names = dao.getBanksNames(connection);
            printList(names);
            dao.setBanksNames(connection, "2");
            System.out.println("\nChanged banks names:");
            names = dao.getBanksNames(connection);
            printList(names);
        }
        connection.close();
    }
}