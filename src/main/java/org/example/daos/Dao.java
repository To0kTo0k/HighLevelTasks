package org.example.daos;

import org.example.Queries;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Dao {
    private final Queries queries = new Queries();

    public List<String> getPersonsFullNames(Connection connection) {
        return queries.getPersonsFullNames(connection);
    }

    public List<String> getBanksNames(Connection connection) {
        return queries.getBanksNames(connection);
    }

    public void setBanksNames(Connection connection, String bankName) {
        queries.setBanksNames(connection, bankName);
    }
}
