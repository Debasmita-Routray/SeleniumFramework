package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exceptions.FrameworkException;

public class ExcelUtils {
	
	public static int getRowCount(String filePath, String sheetName) {

	    try (FileInputStream fis = new FileInputStream(filePath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        return sheet.getLastRowNum();

	    } catch (IOException e) {

	    	throw new FrameworkException(
	                "Unable to read cell data from Excel file: " + filePath,
	                e
	        );
	    }
	}
	
	public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
	
	     
	    try (FileInputStream fis = new FileInputStream(filePath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        if (sheet == null) {
	            throw new RuntimeException("Sheet not found: " + sheetName);
	        }

	        XSSFRow row = sheet.getRow(rowNum);

	        if (row == null) {
	            return "";
	        }

	        XSSFCell cell = row.getCell(colNum);

	        if (cell == null) {
	            return "";
	        }

	        DataFormatter formatter = new DataFormatter();

	        return formatter.formatCellValue(cell);

	    } catch (IOException e) {

	    	throw new FrameworkException(
	                "Unable to read cell data from Excel file: " + filePath,
	                e
	        );
	    }
	        
			
	}

}
