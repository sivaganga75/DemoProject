package com.buffalocart.utility;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.buffalocart.constants.AutomationConstants;
import com.buffalocart.scripts.TestBase;


public class DataRead extends TestBase{
	 public DataRead(WebDriver driver) {
		 // this.driver=driver;
	  }
	 
	
	AutomationConstants constants;
	
	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public String readStringData(int r, int c, String sheetName) throws IOException {
		
		file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
	             + "/Textdata.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(r);
		Cell col = row.getCell(c);
		DataFormatter formatter = new DataFormatter();
		String strValue = formatter.formatCellValue(col);
		
		return strValue;
		
	}
	
	public int getLastColumn(int r, String sheetName) throws IOException {
		
		file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
	             + "/Textdata.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(r);
		int c=row.getLastCellNum();
	
		return c;
		
	}
}
