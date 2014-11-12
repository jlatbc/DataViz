package com.latbc.dataviz.mysql.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.latbc.dataviz.engines.JsonEngine;
import com.latbc.dataviz.exceptions.DatabaseConnectionException;
import com.latbc.dataviz.mysql.dao.DataVizQueryDisplayDAO;
import com.latbc.dataviz.utils.ConnectorDB;
import com.latbc.dataviz.utils.ConstantsDataViz;
import com.latbc.dataviz.utils.DBFactory;

public class DataVizQueryDisplayDAOImpl implements DataVizQueryDisplayDAO {

	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	
	private static final String QRY_ACTIVE_INACTIVE_CLIENT_BY_CITY = "SELECT CI.CITY CITY, "
																+ "CASE CU.ACTIVE WHEN 'true' THEN 'Active' "
																+ "ELSE 'Inactive' END STATUS, "
																+ "COUNT(*) TOTAL "
																+ "FROM SAKILA.CUSTOMER CU "
																+ "INNER JOIN SAKILA.ADDRESS AD ON CU.ADDRESS_ID = AD.ADDRESS_ID "
																+ "INNER JOIN SAKILA.CITY CI ON AD.CITY_ID = CI.CITY_ID "
																+ "GROUP BY STATUS, CI.CITY ";
	
	private static final String QRY_RENTS_BY_CITY_CATEGORY_AND_MONTH = "SELECT DATE_FORMAT(RE.RENTAL_DATE, '%Y-%M') DATE, CI.CITY CITY, "
																+  "CA.NAME , AVG(PA.AMOUNT) AVERAGE_RENT "
																+ "FROM PAYMENT PA "
																+ "INNER JOIN RENTAL RE ON PA.RENTAL_ID = RE.RENTAL_ID "
																+ "INNER JOIN INVENTORY IV ON RE.INVENTORY_ID = IV.INVENTORY_ID "
																+ "INNER JOIN FILM FI ON IV.FILM_ID = FI.FILM_ID "
																+ "INNER JOIN FILM_CATEGORY FC ON FI.FILM_ID = FC.FILM_ID "
																+ "INNER JOIN CATEGORY CA ON FC.CATEGORY_ID = CA.CATEGORY_ID "
																+ "INNER JOIN CUSTOMER CU ON RE.CUSTOMER_ID = CU.CUSTOMER_ID "
																+ "INNER JOIN ADDRESS AD ON CU.ADDRESS_ID = AD.ADDRESS_ID "
																+ "INNER JOIN CITY CI ON AD.CITY_ID = CI.CITY_ID "
																+ "GROUP BY DATE, CI.CITY, CA.NAME ";
	
	private static final String QRY_TOP_TEN_RENTS = "SELECT FI.TITLE, COUNT(*) RENTAS "
										+ "FROM SAKILA.RENTAL RE "
										+ "INNER JOIN SAKILA.INVENTORY IV ON RE.INVENTORY_ID = IV.INVENTORY_ID "
										+ "INNER JOIN SAKILA.FILM FI ON IV.FILM_ID = FI.FILM_ID "
										+ "GROUP BY FI.TITLE "
										+ "ORDER BY RENTAS DESC "
										+ "LIMIT 10 ";
	
	private static final String QRY_TOP_TEN_CLIENT =  "SELECT CONCAT(CU.FIRST_NAME, ' ', CU.LAST_NAME) as CLIENT, SUM(PA.AMOUNT) "
										+ "FROM SAKILA.PAYMENT PA "
										+ "INNER JOIN SAKILA.RENTAL RE ON PA.RENTAL_ID =  RE.RENTAL_ID "
										+ "INNER JOIN SAKILA.CUSTOMER CU ON RE.CUSTOMER_ID = CU.CUSTOMER_ID "
										+ "GROUP BY CLIENT "
										+ "ORDER BY PA.AMOUNT DESC "
										+ "LIMIT 10 ";
	
	private static final String QRY_CLIENT_RENTS_PER_MONTH = "SELECT DISTINCT CONCAT('Semana ', week(re.rental_date), '(', "
													+ "			DATE_FORMAT(RE.RENTAL_DATE, '%Y-%M'), ')') AS DATE "
											+ "FROM SAKILA.RENTAL RE ";
	
	private static final String QRY_INGRESS_PER_CATEGORY = "SELECT CA.NAME, SUM(PA.AMOUNT) "
										+ "FROM SAKILA.PAYMENT PA "
										+ "INNER JOIN SAKILA.RENTAL RE ON PA.RENTAL_ID = RE.RENTAL_ID "
										+ "INNER JOIN SAKILA.INVENTORY IV ON RE.INVENTORY_ID = IV.INVENTORY_ID "
										+ "INNER JOIN SAKILA.FILM FI ON IV.FILM_ID = FI.FILM_ID "
										+ "INNER JOIN SAKILA.FILM_CATEGORY FC ON FI.FILM_ID = FC.FILM_ID "
										+ "INNER JOIN SAKILA.CATEGORY CA ON FC.CATEGORY_ID = CA.CATEGORY_ID "
										+ "GROUP BY CA.NAME ";
	
	private static final String QRY_MOVIES_RENTED_BY_GENERE_MONTH = "SELECT DATE_FORMAT(RE.RENTAL_DATE, '%Y-%M') DATE, FI.RATING , " 
											+ "  COUNT(*) TOTAL "
										      + " FROM SAKILA.RENTAL RE "
										      + " INNER JOIN SAKILA.INVENTORY IV ON RE.INVENTORY_ID = IV.INVENTORY_ID "
										      + " INNER JOIN SAKILA.FILM FI ON IV.FILM_ID = FI.FILM_ID "
										      + " GROUP BY DATE_FORMAT(RE.RENTAL_DATE, '%Y-%M'), FI.RATING ";
	
	@Override
	public void getActiveAndInactiveClientByCity(String active, String inactive) throws SQLException,
			DatabaseConnectionException {
		
		DBFactory dbFactory = new DBFactory();
		
		try{
		ConnectorDB connMySQL = dbFactory.getConnection(ConstantsDataViz.DB_MYSQL );
		statement = connMySQL.getConnection().createStatement();
		resultSet = statement.executeQuery(QRY_ACTIVE_INACTIVE_CLIENT_BY_CITY);
		
		String keyNameJson = "ACTIVE_INACTIVE_CLIENT_BY_CITY";

		JsonEngine jsonEngine = new JsonEngine();
		
		jsonEngine.createJsonFile(resultSet, keyNameJson);
		connMySQL.closeConnection();
		
		} catch (SQLException e ){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
		resultSet.close();
		statement.close();
		}

	}

	@Override
	public void getAVGRentByCityCategoryAndMonth() throws SQLException,
			DatabaseConnectionException {
		
		DBFactory dbFactory = new DBFactory();
		
		try{
		ConnectorDB connMySQL = dbFactory.getConnection(ConstantsDataViz.DB_MYSQL );
		statement = connMySQL.getConnection().createStatement();

		resultSet = statement.executeQuery(QRY_RENTS_BY_CITY_CATEGORY_AND_MONTH);
		
		String keyNameJson = "RENTS_BY_CITY_CATEGORY_AND_MONTH";

		JsonEngine jsonEngine = new JsonEngine();
		
		jsonEngine.createJsonFile(resultSet, keyNameJson);
		connMySQL.closeConnection();
		
		} catch (SQLException e ){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
		resultSet.close();
		statement.close();
		}

	}


	@Override
	public void getRentTopTen() throws SQLException,
			DatabaseConnectionException {
		
		DBFactory dbFactory = new DBFactory();
		
		try{
		ConnectorDB connMySQL = dbFactory.getConnection(ConstantsDataViz.DB_MYSQL );
		statement = connMySQL.getConnection().createStatement();
		
		resultSet = statement.executeQuery(QRY_TOP_TEN_RENTS);
		
		String keyNameJson = "TOP_TEN_RENTS";

		JsonEngine jsonEngine = new JsonEngine();
		
		jsonEngine.createJsonFile(resultSet, keyNameJson);
		connMySQL.closeConnection();
		
		} catch (SQLException e ){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
		resultSet.close();
		statement.close();
		}

	}

	@Override
	public void getClientByTopTenRent() throws SQLException,
			DatabaseConnectionException {
		
		DBFactory dbFactory = new DBFactory();
		
		try{
		ConnectorDB connMySQL = dbFactory.getConnection(ConstantsDataViz.DB_MYSQL );
		statement = connMySQL.getConnection().createStatement();
		
		resultSet = statement.executeQuery(QRY_TOP_TEN_CLIENT);
		
		String keyNameJson = "TOP_TEN_CLIENT_SPEND";

		JsonEngine jsonEngine = new JsonEngine();
		
		jsonEngine.createJsonFile(resultSet, keyNameJson);
		connMySQL.closeConnection();
		
		} catch (SQLException e ){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
		resultSet.close();
		statement.close();
		}
	}

	@Override
	public void getClientRentsPerWeek() throws SQLException,
			DatabaseConnectionException {

		DBFactory dbFactory = new DBFactory();
		
		try{
		ConnectorDB connMySQL = dbFactory.getConnection(ConstantsDataViz.DB_MYSQL );
		statement = connMySQL.getConnection().createStatement();
		
		resultSet = statement.executeQuery(QRY_CLIENT_RENTS_PER_MONTH);
		
		String keyNameJson = "CLIENT_RENTS_PER_MONTH";

		JsonEngine jsonEngine = new JsonEngine();
		
		jsonEngine.createJsonFile(resultSet, keyNameJson);
		connMySQL.closeConnection();
		
		} catch (SQLException e ){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
		resultSet.close();
		statement.close();
		}
		

	}

	@Override
	public void getEntryByCategory() throws SQLException,
			DatabaseConnectionException {
		
		DBFactory dbFactory = new DBFactory();
		
		try{
		ConnectorDB connMySQL = dbFactory.getConnection(ConstantsDataViz.DB_MYSQL );
		statement = connMySQL.getConnection().createStatement();
		
		resultSet = statement.executeQuery(QRY_INGRESS_PER_CATEGORY);
		
		String keyNameJson = "INGRESS_PER_CATEGORY";

		JsonEngine jsonEngine = new JsonEngine();
		
		jsonEngine.createJsonFile(resultSet, keyNameJson);
		connMySQL.closeConnection();
		
		} catch (SQLException e ){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
		resultSet.close();
		statement.close();
		}
	}

	@Override
	public void getMoviesByGenereAndMonth() throws SQLException,
			DatabaseConnectionException {

		DBFactory dbFactory = new DBFactory();
		
		try{
		ConnectorDB connMySQL = dbFactory.getConnection(ConstantsDataViz.DB_MYSQL );
		statement = connMySQL.getConnection().createStatement();
		
		resultSet = statement.executeQuery(QRY_MOVIES_RENTED_BY_GENERE_MONTH);
		
		String keyNameJson = "MOVIES_RENTED_BY_GENERE_MONTH";

		JsonEngine jsonEngine = new JsonEngine();
		
		jsonEngine.createJsonFile(resultSet, keyNameJson);
		connMySQL.closeConnection();
		
		} catch (SQLException e ){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
		resultSet.close();
		statement.close();
		}

	}

}
