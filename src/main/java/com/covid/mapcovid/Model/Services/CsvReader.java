package com.covid.mapcovid.Model.Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.covid.mapcovid.Model.Entities.CovidData;

public class CsvReader {
	
	public List<CovidData> execute() throws IOException {
    	
    	File excelFile = new File("src/main/webapp/excel/owid-covid-data.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        workbook.setMissingCellPolicy(MissingCellPolicy.RETURN_BLANK_AS_NULL);
        
        DataFormatter fmt = new DataFormatter();

        List<CovidData> lista = new ArrayList<CovidData>(); 

   	 	String addString = " ";

        for(int sn = 0; sn <workbook.getNumberOfSheets(); sn++) {
        	
           XSSFSheet sheet = workbook.getSheetAt(0);
           
           for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
        	   
              Row row = sheet.getRow(i);
              
              if (row == null) {
            	  
              } else {
            	 
                 for (int j = 0; j < row.getLastCellNum(); j++) {
                	 
                    Cell cell = row.getCell(j);
                                        
                    if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                    	addString += "null/";
                    } else {
                       String cellStr = fmt.formatCellValue(cell);
                       
                       addString += cellStr + "/";
                       
                    }
                 }
                     
                 
                 CovidData covidData = new CovidData(addString);
                                               
                 lista.add(covidData);
                 
                 addString = "";
              }
           }  
        }
        
        workbook.close();
        fis.close();
        
        return lista;
        
    }

}
