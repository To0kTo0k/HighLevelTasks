package org.example;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceFactory {
    private DataSourceFactory() {
        throw new IllegalStateException();
    }

    public static Connection getNewConnection() {
        Connection connection = null;
        try {
            connection = getDataSource().getConnection();
        } catch (SQLException e) {
            System.out.println("SQL Exception\nSQL State: " + e.getSQLState() + " " + e.getMessage());
        }
        return connection;
    }

    private static DataSource getDataSource() {
        PGSimpleDataSource pgDS = new PGSimpleDataSource();
        pgDS.setURL("jdbc:postgresql://localhost:5432/bankdb");
        pgDS.setUser("springroot");
        pgDS.setPassword("3041");
        return pgDS;
    }
}
