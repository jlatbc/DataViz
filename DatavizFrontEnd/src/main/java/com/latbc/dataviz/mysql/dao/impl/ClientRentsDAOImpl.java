package com.latbc.dataviz.mysql.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.latbc.dataviz.engines.JsonEngine;
import com.latbc.dataviz.exceptions.DatabaseConnectionException;
import com.latbc.dataviz.mysql.dao.ClientRentsDAO;
import com.latbc.dataviz.utils.ConnectorDB;
import com.latbc.dataviz.utils.ConstantsDataViz;
import com.latbc.dataviz.utils.DBFactory;

public class ClientRentsDAOImpl implements ClientRentsDAO {

	private static Statement statement = null;
	private static ResultSet resultSet = null;

	private static final String QRY_RENTAS_ID_CLIENTE = "SELECT re.rental_id, re.inventory_id, re.rental_date, "
			+ "concat(cust.first_name, \" \",cust.last_name) AS NAME, cust.customer_id, f.title "
			+ "from customer cust, rental re, inventory inv, film f "
			+ "where cust.customer_id = re.customer_id "
			+ "and re.inventory_id = inv.inventory_id "
			+ "and inv.film_id = f.film_id " + "and cust.customer_id = ";

	public void getRentsByCustomerId(String idCustomer) throws SQLException,
			DatabaseConnectionException {

		DBFactory dbFactory = new DBFactory();

		try {
			// Temporal variable, this task must be work with real parameters
			// with beans
			String tmpVariable = QRY_RENTAS_ID_CLIENTE + idCustomer;

			ConnectorDB connMySQL = dbFactory
					.getConnection(ConstantsDataViz.DB_MYSQL);

			statement = connMySQL.getConnection().createStatement();

			resultSet = statement.executeQuery(tmpVariable);

			String keyNameJson = "RENTS_BY_ID_CLIENT";

			JsonEngine jsonEngine = new JsonEngine();

			jsonEngine.createJsonFile(resultSet, keyNameJson);
			connMySQL.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			statement.close();
		}

	}

	public void rentasPorNombreCliente() {
		// TODO Auto-generated method stub

	}

}
