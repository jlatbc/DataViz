package com.latbc.dataviz.mysql.dao.impl;

import java.sql.SQLException;


import com.latbc.dataviz.exceptions.DatabaseConnectionException;

public class TestDataVizQueryDisplayDAO {

	public static void main(String[] args) {
		
		DataVizQueryDisplayDAOImpl dataVizQuery = new DataVizQueryDisplayDAOImpl();
		
		//Execute test, creating json file
		try {
			
			//dataVizQuery.getActiveAndInactiveClientByCity("", "");
			//dataVizQuery.getAVGRentByCityCategoryAndMonth();
			//dataVizQuery.getRentTopTen();
			//dataVizQuery.getClientByTopTenRent();
			//dataVizQuery.getClientRentsPerWeek();
			//dataVizQuery.getEntryByCategory();
			dataVizQuery.getMoviesByGenereAndMonth();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//testMySQL.executeQry();

	}

}
