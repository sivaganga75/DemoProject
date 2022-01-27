package com.buffalocart.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.buffalocart.scripts.TestBase;

public class ExcelUtility extends TestBase{
	
	DataRead dataRead = new DataRead(driver);
	ArrayList<String> data;
	
	public ArrayList<String> readExcel(int r, String sheetName) throws IOException{
		data = new ArrayList<String>();
		
		int column = dataRead.getLastColumn(r, sheetName);
		
		for(int i=0; i<=column; i++) {
			data.add(dataRead.readStringData(r, i, sheetName));
		}
		
		return data;
	}
	
}
	
/*	
	
	private static  XSSFWorkbook excelWBook; //Excel WorkBook
    private static   XSSFSheet    excelWSheet; //Excel Sheet
    
    public static String getStringCellData(int RowNum, int ColNum) throws IOException {
    
    // Open the Excel file
	 FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
             + "/Textdata.xlsx");
    excelWBook = new XSSFWorkbook(ExcelFile);
    excelWSheet = excelWBook.getSheetAt(0);//accessing the sheet by index
   // excelWSheet.getSheet(Sheet1); accessing the sheet by name
   
    return excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
    }*/
   /* public static int getNumericCellData(int RowNum, int ColNum) throws IOException {
        
        // Open the Excel file
    	 FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
                 + "/Buffalocart.xlsx");
        excelWBook = new XSSFWorkbook(ExcelFile);
        //accessing the sheet by index
        excelWSheet = excelWBook.getSheetAt(0);
       //accessing the sheet by name
        //excelWBook.getSheet(Sheet1);
    return (int) excelWSheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
    }} */
    
  /* public static String getNumericCellData(int RowNum, int ColNum) throws IOException{
        
        // Open the Excel file
    	 FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
                 + "/Textdata.xlsx");
        excelWBook = new XSSFWorkbook(ExcelFile);
        //excelWSheet = excelWBook.getSheetAt(0);//accessing the sheet by index
       // excelWSheet.getSheet(Sheet1); accessing the sheet by name
    	Cell cell = excelWBook .getSheetAt(0).getRow(RowNum).getCell(ColNum);
    	cell.setCellType(Cell.CELL_TYPE_STRING);
    	String pass = cell.getStringCellValue();
    	return pass;
    	}}
       
     

*/