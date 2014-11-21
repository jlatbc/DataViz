package com.latbc.datavizfrontend.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class DataBaseConnectionView {
	
	private int dbId;
	private List<MenuOption> dbTypes;
	
	@PostConstruct
	public void init(){
		dbTypes = new ArrayList<MenuOption>();
		
		MenuOption menuOption = new MenuOption();
		menuOption.setId(1);
		menuOption.setName("Oracle DataBase");
		dbTypes.add(menuOption);
		
		menuOption = new MenuOption();
		menuOption.setId(2);
		menuOption.setName("MySQL DataBase");
		dbTypes.add(menuOption);
		
		menuOption = new MenuOption();
		menuOption.setId(3);
		menuOption.setName("SQLServer DataBase");
		dbTypes.add(menuOption);
		
	}
	
	public void configureDBType(){
		
		try {
			if(dbId == 1){
				FacesContext.getCurrentInstance().getExternalContext().redirect("oracleDBConfiguration.xhtml");
			} else if(dbId == 2){
				FacesContext.getCurrentInstance().getExternalContext().redirect("mySQLDBConfiguration.xhtml");
			}else if(dbId == 3){												
				FacesContext.getCurrentInstance().getExternalContext().redirect("sqlServerDBConfiguration.xhtml");
			}
			
		} catch (IOException e) {
			System.out.println("Into catch of configureDBType");
			e.printStackTrace();
		}
	}

	
	public int getDbId() {
		return dbId;
	}

	public void setDbId(int dbId) {
		this.dbId = dbId;
	}

	public List<MenuOption> getDbTypes() {
		return dbTypes;
	}

	public void setDbTypes(List<MenuOption> dbTypes) {
		this.dbTypes = dbTypes;
	}

	
}
