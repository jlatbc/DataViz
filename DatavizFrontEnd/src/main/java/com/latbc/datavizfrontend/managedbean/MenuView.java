package com.latbc.datavizfrontend.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class MenuView {
	
	private int source;
	private List<MenuOption> sourcesData;
	
	@PostConstruct
	public void init(){
		sourcesData = new ArrayList<MenuOption>();
		
		MenuOption menuOption = new MenuOption();
		menuOption.setId(1);
		menuOption.setName("Create json from DB");
		
		sourcesData.add(menuOption);
		
		menuOption = new MenuOption();
		menuOption.setId(2);
		menuOption.setName("Create json from Excel");
		sourcesData.add(menuOption);
		
		menuOption = new MenuOption();
		menuOption.setId(3);
		menuOption.setName("New Data Base Connection Configuration");		
		sourcesData.add(menuOption);
		
		menuOption = new MenuOption();
		menuOption.setId(4);
		menuOption.setName("View Graphic From Source");		
		sourcesData.add(menuOption);
		
	}
	
	
	public void openActionButton(){
		
		try {
			
			if(source == 1){
				FacesContext.getCurrentInstance().getExternalContext().redirect("executeReport.xhtml");
			} else if(source == 2){
				FacesContext.getCurrentInstance().getExternalContext().redirect("excelUpload.xhtml");
			} else if(source == 3){
				FacesContext.getCurrentInstance().getExternalContext().redirect("createDBConnection.xhtml");
			}  else if(source == 4){
				FacesContext.getCurrentInstance().getExternalContext().redirect("createGraphic.xhtml");
			}
			
			
		} catch (IOException e) {
			System.out.println("Into catch of openActionButton");
			e.printStackTrace();
		}
	}

	
	
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public List<MenuOption> getSourcesData() {
		return sourcesData;
	}
	public void setSourcesData(List<MenuOption> sourcesData) {
		this.sourcesData = sourcesData;
	}
	

}
