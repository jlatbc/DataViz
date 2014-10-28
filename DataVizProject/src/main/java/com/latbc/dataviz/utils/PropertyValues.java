package com.latbc.dataviz.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyValues {

	public String getPropValues() throws IOException{
		
		String result = "";
		Properties prop = new Properties();
		String propFile = "src/main/resources/config.properties";
		
		InputStream inputStream = new FileInputStream(propFile);

		System.out.println(inputStream); 
		prop.load(inputStream);
		String url = prop.getProperty("urlMySQL");
		String user = prop.getProperty("userNameMySQL");
		
		return null;
		
	}
	
}