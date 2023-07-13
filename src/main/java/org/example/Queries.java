package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    public List<String> getPersonsFullNames(Connection connection) throws SQLException {
        Statement statement = null;
        List<String> fullNames = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT full_name FROM person");
            fullNames = new ArrayList<>();
            while (resultSet.next()) {
                fullNames.add(resultSet.getString("full_name"));
            }
        } catch (SQLException e) {
            System.out.println("Connection error");
        } finally {
            statement.close();
        }
        return fullNames;
    }

    public List<String> getBanksNames(Connection connection) throws SQLException {
        Statement statement = null;
        List<String> names = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM bank");
            names = new ArrayList<>();
            while(resultSet.next()) {
                names.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("Connection error");
        } finally {
            statement.close();
        }
        return names;
    }

    public void setBanksNames(Connection connection, String bankName) throws SQLException {
        PreparedStatement statement = null;
        connection.setAutoCommit(false);
        try {
            statement = connection.prepareStatement("UPDATE bank SET name = ?");
            statement.setString(1, bankName);
            statement.executeUpdate();
        } catch (SQLException e) {
            connection.rollback();
            System.out.println("Connection error");
        } finally {
            connection.setAutoCommit(true);
            statement.close();
        }
    }
}
