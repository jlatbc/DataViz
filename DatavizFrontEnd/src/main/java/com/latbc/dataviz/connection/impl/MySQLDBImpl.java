package com.latbc.dataviz.connection.impl;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.latbc.dataviz.beans.ConnectionBean;
import com.latbc.dataviz.utils.ConnectorDB;

public class MySQLDBImpl implements ConnectorDB {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MySQLDBImpl.class);
	private static Connection connection = null;
	Properties prop = new Properties();

	public void createConnection(ConnectionBean connBean) {
		
        try {
            Class.forName(connBean.getDriver()
            ).newInstance();	
            connection = DriverManager.getConnection(connBean.getUrl(),
                    connBean.getUser(),
                    connBean.getPassword());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            LOGGER.info("Error: " + ex);
        }
    }

	public Connection getConnection() throws SQLException {
		

		try {
			prop.load(MySQLDBImpl.class.getResourceAsStream("/config.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String driver = prop.getProperty("driverMySQL").toString();
		
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = DriverManager.getConnection(prop.getProperty("urlMySQL") + prop.getProperty("dbNameMySQL"),
												prop.getProperty("userNameMySQL"),
												prop.getProperty("passwordMySQL"));
			return connection;
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

}
