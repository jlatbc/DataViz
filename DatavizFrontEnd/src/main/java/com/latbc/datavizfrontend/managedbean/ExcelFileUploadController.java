package com.latbc.datavizfrontend.managedbean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.latbc.dataviz.engines.ExcelExtractionEngine;


@ManagedBean
public class ExcelFileUploadController {

    public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
        	System.out.println("Into catch of FileUploaderController");
//        	System.out.println("file name: " + event.getFile().getFileName());
        	System.out.println("InputStream: " + event.getFile().getInputstream());
            //copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            createJsonFromExcel(event.getFile().getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
    
    private void createJsonFromExcel(String fileName){
    	
    	ExcelExtractionEngine excelExtractor = new ExcelExtractionEngine();
    	
    	String outputPath = "C:/DataVizTestContainer/excel_json/excelJson.json";
    	
    	try {
			excelExtractor.getJSONFromExcelFile(fileName, outputPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private void copyFile(String fileName, InputStream in) {
        try {
           
        	System.out.println("Into copyFile");
             // write the inputStream to a FileOutputStream
             OutputStream out = new FileOutputStream(new File(fileName));
           
             int read = 0;
             byte[] bytes = new byte[1024];
           
             while ((read = in.read(bytes)) != -1) {
                 out.write(bytes, 0, read);
             }
           
             in.close();
             out.flush();
             out.close();
           
             System.out.println("New file created!");
             } catch (IOException e) {
             System.out.println(e.getMessage());
             }
  
 }
}
