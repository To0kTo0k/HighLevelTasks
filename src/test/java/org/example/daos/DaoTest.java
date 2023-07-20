package org.example.daos;

import org.example.DataSourceFactory;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DaoTest {

    Dao dao = new Dao();

    @Test
    void getPersonsFullNames() {
        Connection connection = DataSourceFactory.getNewConnection();
        assertNotNull(dao.getPersonsFullNames(connection));
    }

    @Test
    void getBanksNames() {
        Connection connection = DataSourceFactory.getNewConnection();
        assertNotNull(dao.getBanksNames(connection));
    }

    @Test
    void setBanksNames() {
        Connection connection = DataSourceFactory.getNewConnection();
        dao.setBanksNames(connection, "0");
        assertEquals("0", dao.getBanksNames(connection).get(0));
    }
}