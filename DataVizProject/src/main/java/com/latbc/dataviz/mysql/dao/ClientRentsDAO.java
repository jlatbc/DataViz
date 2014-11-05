package com.latbc.dataviz.mysql.dao;

import java.sql.SQLException;

import com.latbc.dataviz.exceptions.DatabaseConnectionException;

public interface ClientRentsDAO {

	public void getRentsByCustomerId(String idCustomer) throws SQLException,
			DatabaseConnectionException;

	// InstantiationException
	// , IllegalAccessException
	// , ClassNotFoundException
	// , FileNotFoundException

	public void rentasPorNombreCliente();

}