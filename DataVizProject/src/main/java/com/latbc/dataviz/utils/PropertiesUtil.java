package com.latbc.dataviz.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Latbc
 */
public class PropertiesUtil {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PropertiesUtil.class);

	String path;
	Properties prop;

	public void loadProperties() throws IOException {

		try {
			InputStream inputStream = new FileInputStream(path);
			prop = new Properties();
			prop.load(inputStream);
		} catch (FileNotFoundException ex) {
			LOGGER.debug("Error" + ex);
		}

	}

	public String getProperty(String propertyName) {

		return prop.getProperty(propertyName);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

}
