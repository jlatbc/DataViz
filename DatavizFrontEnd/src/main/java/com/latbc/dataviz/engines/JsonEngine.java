package com.latbc.dataviz.engines;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

public class JsonEngine {

	public void createJsonFile(ResultSet resultSet, String keyNameJson)
			throws IOException {
		
		File file = new File(
				"C:/DataVizTestContainer/json/"+keyNameJson+".json");
		FileWriter fw = null;
		BufferedWriter bw = null;

		String jsonOutPut = getJSONFromResultSet(resultSet, keyNameJson);

		try {
			if (!file.exists()) {
				file.createNewFile();

			}

			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(jsonOutPut);
			bw.flush();
			bw.close();

			System.out.println("File Created with BufferedWriter");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				fw.close();
			}
			if (bw != null) {
				bw.close();
			}
		}

	}

	private String getJSONFromResultSet(ResultSet rs, String keyName) {
		
		Map<String, Object> json = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();

		if (rs != null) {

			try {

				ResultSetMetaData metaData = rs.getMetaData();
				
				while (rs.next()) {

					Map<String, Object> columnMap = new HashMap<String, Object>();

					// Obtiene el numero de columnas de un registro
					for (int columnIndex = 1; columnIndex <= metaData
							.getColumnCount(); columnIndex++) {

						// Obtiene el nombre de la columna
						if (rs.getString(metaData.getColumnName(columnIndex)) != null) {

							columnMap.put(metaData.getColumnLabel(columnIndex),
									rs.getString(metaData
											.getColumnName(columnIndex)));
						} else {

							// Si el campo viene pone la etiqueta CAMPO-VACIO
							columnMap.put(metaData.getColumnLabel(columnIndex),
									"EMPTY-FIELD");
						}
					}
					list.add(columnMap);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			json.put(keyName, list);
		} else {
			System.out.println("ResultSet is null");
		}
		return JSONValue.toJSONString(json);
	}

}// Termina Clase

