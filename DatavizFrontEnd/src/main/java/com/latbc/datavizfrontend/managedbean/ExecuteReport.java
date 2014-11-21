package com.latbc.datavizfrontend.managedbean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import com.latbc.dataviz.exceptions.DatabaseConnectionException;
import com.latbc.dataviz.mysql.dao.impl.DataVizQueryDisplayDAOImpl;


@ManagedBean
public class ExecuteReport {

	public void runReportGetActiveInactiveClient(){
		
		DataVizQueryDisplayDAOImpl dataVizImpl = new DataVizQueryDisplayDAOImpl();
		
		try {
			dataVizImpl.getActiveAndInactiveClientByCity("", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	public void runReportGetAVGRentByCityCategoryAndMonth(){
		
		DataVizQueryDisplayDAOImpl dataVizImpl = new DataVizQueryDisplayDAOImpl();
		
		try {
			dataVizImpl.getAVGRentByCityCategoryAndMonth();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void runReportGetRentTopTen(){
		
		DataVizQueryDisplayDAOImpl dataVizImpl = new DataVizQueryDisplayDAOImpl();
		
		try {
			dataVizImpl.getRentTopTen();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void runReportGetClientByTopTenRent(){
		
		DataVizQueryDisplayDAOImpl dataVizImpl = new DataVizQueryDisplayDAOImpl();
		
		try {
			dataVizImpl.getClientByTopTenRent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void runReportGetClientRentsPerWeek(){
		
		DataVizQueryDisplayDAOImpl dataVizImpl = new DataVizQueryDisplayDAOImpl();
		
		try {
			dataVizImpl.getClientRentsPerWeek();;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void runReportGetEntryByCategory(){
		
		DataVizQueryDisplayDAOImpl dataVizImpl = new DataVizQueryDisplayDAOImpl();
		
		try {
			dataVizImpl.getEntryByCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void runReportGetMoviesByGenereAndMonth(){
		
		DataVizQueryDisplayDAOImpl dataVizImpl = new DataVizQueryDisplayDAOImpl();
		
		try {
			dataVizImpl.getMoviesByGenereAndMonth();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
