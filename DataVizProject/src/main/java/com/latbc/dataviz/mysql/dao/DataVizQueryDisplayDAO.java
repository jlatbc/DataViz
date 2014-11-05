package com.latbc.dataviz.mysql.dao;

import java.sql.SQLException;
import com.latbc.dataviz.exceptions.DatabaseConnectionException;

public interface DataVizQueryDisplayDAO {

	public void getActiveAndInactiveClientByCity(String active, String inactive) throws SQLException,
	DatabaseConnectionException;
	
	public void getAVGRentByCityCategoryAndMonth() throws SQLException,
	DatabaseConnectionException;
	
	public void getRentTopTen() throws SQLException,
	DatabaseConnectionException;

	public void getClientByTopTenRent() throws SQLException,
	DatabaseConnectionException;

	public void getClientRentsPerWeek() throws SQLException,
	DatabaseConnectionException;
	
	public void getEntryByCategory() throws SQLException,
	DatabaseConnectionException;
	
	public void getMoviesByGenereAndMonth() throws SQLException,
	DatabaseConnectionException;
	
}
