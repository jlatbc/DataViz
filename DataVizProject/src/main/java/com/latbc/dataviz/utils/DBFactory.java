package com.latbc.dataviz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;






import com.latbc.dataviz.connection.impl.MySQLDBImpl;


import com.latbc.dataviz.connection.impl.OracleDBImpl;
import com.latbc.dataviz.connection.impl.SQLServerImpl;

import java.sql.SQLException;
import java.sql.Connection;

public class DBFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBFactory.class);

    private Connection connection;

    public ConnectorDB getConnection(String connectorDBType) throws SQLException{

		if (connectorDBType == null){
			System.out.println("connectorDBType is Null");
			return null;
		} else if (connectorDBType.equalsIgnoreCase(ConstantsDataViz.DB_MYSQL)){
			return new MySQLDBImpl();
		} else if (connectorDBType.equalsIgnoreCase(ConstantsDataViz.DB_ORACLE)){
			return new OracleDBImpl();
		} else if (connectorDBType.equalsIgnoreCase(ConstantsDataViz.DB_SQL_SERVER)){
			return new SQLServerImpl();
		} else {
			System.out.println(" Falta crear mensaje en DBFactory para el ELSE ");
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
