package com.latbc.dataviz.engines;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Latbc
 */
public class ExcelExtractionEngine {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ExcelExtractionEngine.class);

	// public static void main(String[] args) throws IOException {
	//
	// ExcelExtractionEngine excelEngine = new ExcelExtractionEngine();
	// excelEngine.jsonFromExcelFile();
	//
	// }
	public void getJSONFromExcelFile(String rootPathXLS, String outputPath)
			throws FileNotFoundException, IOException {
		// Start constructing JSON.
		JSONObject json = new JSONObject();
		try {
			// FileInputStream file = new FileInputStream(new
			// File("C:/Users/Latbc/Desktop/test_folder/ReadTest.xlsx"));
			FileInputStream file = new FileInputStream(new File(rootPathXLS));

			// Crea una instancia de Workbook
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtiene la primer pesta�a del workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Recorre las filas
			JSONArray rows = new JSONArray();
			for (Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext();) {
				Row row = rowsIT.next();
				JSONObject jRow = new JSONObject();

				// Recorre las celdas
				JSONArray cells = new JSONArray();
				for (Iterator<Cell> cellsIT = row.cellIterator(); cellsIT
						.hasNext();) {
					Cell cell = cellsIT.next();
					cells.add(cell.getStringCellValue());
				}
				jRow.put("cell", cells);
				rows.add(jRow);
			}

			// Crear el JSON
			json.put("RESULT:", rows);

		} catch (IOException e) {
			LOGGER.debug(e.getMessage());
		}

		LOGGER.info(json.toString());

		createJsonFromExcel(outputPath, json.toString());

	}

	public void createJsonFromExcel(String fileName, String st)
			throws IOException {

		File file = new File(fileName);
		FileWriter fw = null;
		BufferedWriter bw = null;

		// String jsonOutPut = getJSONFromExcelFile();
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(st);
			bw.flush();
			bw.close();

			System.out.println("File Created with BufferedWriter EXCEL");

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

}