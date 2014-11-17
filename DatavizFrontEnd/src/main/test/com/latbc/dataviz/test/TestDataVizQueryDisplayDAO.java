package com.latbc.dataviz.test;

import java.sql.SQLException;
import com.latbc.dataviz.exceptions.DatabaseConnectionException;
import com.latbc.dataviz.mysql.dao.impl.DataVizQueryDisplayDAOImpl;

public class TestDataVizQueryDisplayDAO {

	public static void main(String[] args) {
		
		DataVizQueryDisplayDAOImpl dataVizQuery = new DataVizQueryDisplayDAOImpl();
		
		//Execute test, creating json file
		try {
			
//			dataVizQuery.getActiveAndInactiveClientByCity("", "");
//			dataVizQuery.getAVGRentByCityCategoryAndMonth();
//			dataVizQuery.getRentTopTen();
//			dataVizQuery.getClientByTopTenRent();
//			dataVizQuery.getClientRentsPerWeek();
//			dataVizQuery.getEntryByCategory();
			dataVizQuery.getMoviesByGenereAndMonth();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//testMySQL.executeQry();

	}

}
	