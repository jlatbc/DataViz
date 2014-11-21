package com.latbc.datavizfrontend.managedbean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SQLServerConnection {

	private String conncetionName;
	private String url;
	private String user;
	private String password;
	
	
	public String getConncetionName() {
		return conncetionName;
	}
	public void setConncetionName(String conncetionName) {
		this.conncetionName = conncetionName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
