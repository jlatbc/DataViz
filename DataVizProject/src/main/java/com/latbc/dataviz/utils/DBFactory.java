package com.latbc.dataviz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.latbc.dataviz.connection.impl.MySQLDBImpl;

import java.sql.SQLException;
import java.sql.Connection;

public class DBFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBFactory.class);

    private Connection connection;

    public ConnectorDB getConnection(String connectorDBType) throws SQLException{

        if (connectorDBType == null) {
            LOGGER.info("connectorDBType is Null");
            return null;
        } else if (connectorDBType.equalsIgnoreCase("MySQL")) {
            System.out.println("Connection created");
            return new MySQLDBImpl();
        }

        return null;
    }

    public void closeConnection() throws SQLException {

        if (connection != null) {
            try {
                connection.close();
                LOGGER.info("Connection closed !!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        

    }

}
