package com.latbc.dataviz.connection.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.latbc.dataviz.beans.ConnectionBean;
import com.latbc.dataviz.utils.ConnectorDB;

public class MySQLDBImpl implements ConnectorDB {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MySQLDBImpl.class);
	private static Connection connection = null;

	public void createConnection(ConnectionBean connBean) {
        try {

//            String driver = connBean.getDriver();
            Class.forName(connBean.getDriver()
            ).newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://"+ connBean.getUrl(),
//            connection = DriverManager.getConnection("jdbc:mysql://"+ connBean.getUrl() + connBean.getDbName(),
                    connBean.getUser(),
                    connBean.getPassword());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            LOGGER.info("Error: " + ex);
        }
    }

	public Connection getConnection() throws SQLException {

		return connection;
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

}
