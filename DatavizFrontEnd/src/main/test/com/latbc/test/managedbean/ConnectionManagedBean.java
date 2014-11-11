package com.latbc.test.managedbean;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.latbc.dataviz.beans.ConnectionBean;
import com.latbc.dataviz.utils.ConnectorDB;
import com.latbc.dataviz.utils.DBFactory;
import com.latbc.dataviz.utils.PropertiesUtil;

@ManagedBean
public class ConnectionManagedBean {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConnectionManagedBean.class);

	ConnectionBean connectionBean = new ConnectionBean();
	public ConnectionBean getConnectionBean() {
		return connectionBean;
	}

	public void setConnectionBean(ConnectionBean connectionBean) {
		this.connectionBean = connectionBean;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	String url;
	String user;
	String pass;
	
	
	PropertiesUtil propUtil = new PropertiesUtil();
	DBFactory dbFactory = new DBFactory();

	public void loadProperties() {
		
		System.out.println("SI ENTRA AL METODO");
		propUtil.setPath("src//main//resources//config.properties");
		try {
			propUtil.loadProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		url = propUtil.getProperty("urlMySQL");
		user = propUtil.getProperty("userNameMySQL");
		pass = propUtil.getProperty("passwordMySQL");

		connectionBean.setDriver("com.mysql.jdbc.Driver");
		connectionBean.setDbName("person_db_test");
		
        //Compara que el valor
//        if (url != null && url.equals(url)) {
//            connectionBean.setUrl(url);
//            LOGGER.info("URL--");
//        }
//
//        if (user != null && user.equals(user)) {
//            connectionBean.setUser(user);
//            LOGGER.info("URL--");
//        }
//		
//        if (pass != null && pass.equals(pass)) {
//            connectionBean.setPassword(pass);
//            LOGGER.info("URL--");
//        }
		
        ConnectorDB connectorDB;

        try {
			connectorDB = dbFactory.getConnection("MySQL");
			connectorDB.createConnection(connectionBean);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}// Termina loadProperties

}
