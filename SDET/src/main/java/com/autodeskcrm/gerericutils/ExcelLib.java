package com.autodeskcrm.gerericutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Deepak
 *
 */
public class ExcelLib {
	String filePAth = "./testData/testScriptData.xlsx";
   /**
    * used to read the data from excel workook based on
    * @param shettName
    * @param rowNum
    * @param colNum
    * @return
    * @throws Throwable
    */
	public String getExcelData(String shettName , int rowNum , int colNum) throws Throwable {
		FileInputStream fis = new FileInputStream(filePAth);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shettName);
		Row row = sh.getRow(rowNum);
		wb.close();
		return row.getCell(colNum).getStringCellValue();
				
	}
	/**
	 * used to set data back to excel based on parameter
	 * @param shettName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void setExcelData(String shettName , int rowNum , int colNum ,String data) throws Throwable {
		FileInputStream fis = new FileInputStream(filePAth);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shettName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(filePAth);
				wb.write(fos);
		wb.close();
	}
	/**
	 * used to get the excel used row count
	 * @param shettName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String shettName)throws Throwable {
		FileInputStream fis = new FileInputStream(filePAth);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shettName);
	
		return sh.getLastRowNum();
				
	}
	
}









