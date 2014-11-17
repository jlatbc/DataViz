package com.latbc.dataviz.engines;

/**
 *
 * @author Latbc
 */
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.latbc.dataviz.utils.ConnectorDB;
import com.latbc.dataviz.utils.DBFactory;

public class ExtractionEngine {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ExtractionEngine.class);

	private static Statement statement = null;
	private static ResultSet resultSet = null;

	public void executeQry() throws SQLException {

		DBFactory dbFactory = new DBFactory();

		try {
			ConnectorDB connMySQL = dbFactory.getConnection("MySQL");
			statement = connMySQL.getConnection().createStatement();
			resultSet = statement
					.executeQuery("SELECT re.rental_id, re.inventory_id, re.rental_date, "
							+ "concat(cust.first_name, \" \",cust.last_name) AS NAME, cust.customer_id, f.title "
							+ "from customer cust, rental re, inventory inv, film f "
							+ "where cust.customer_id = re.customer_id "
							+ "and re.inventory_id = inv.inventory_id "
							+ "and inv.film_id = f.film_id "
							+ "and cust.customer_id = 1");

			String keyNameJson = "CUSTOMER_FILM_RENT";
			JsonEngine jsonEngine = new JsonEngine();

			jsonEngine.createJsonFile(resultSet, keyNameJson);
			connMySQL.closeConnection();

		} catch (SQLException | IOException e) {
			LOGGER.debug("Error: " + e.getMessage());
		} finally {
			resultSet.close();
			statement.close();

		}

	}
}