package com.latbc.dataviz.utils;

import com.latbc.dataviz.beans.ConnectionBean;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectorDB {
	
	Connection getConnection() throws SQLException;
	
	void closeConnection()  throws SQLException ;
        
    void createConnection(ConnectionBean connectionBean) throws SQLException;
	
}