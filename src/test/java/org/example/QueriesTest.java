package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueriesTest {


    @Test
    void setBanksNames() throws SQLException {
        Connection connection = DataSourceFactory.getNewConnection();
        Queries queries = new Queries();
        queries.setBanksNames(connection, "1");
        List<String> list = queries.getBanksNames(connection);
        assertEquals("1", list.stream().distinct().toList().get(0));
    }
}