package com.crm.qa.util;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;



import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.BaseTest;

public class TestUtil extends BaseTest{
	
	public static String Test_Data_Sheet_Path="C:\\Users\\VIJAYALAKSHMINAKKA\\eclipse-workspace\\FreeCRMTestAutomation\\"
			+ "src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file=new FileInputStream(Test_Data_Sheet_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=workbook.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
				
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		String currentDir=System.getProperty("user.dir");
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		FileHandler.copy(screenshot, new File(currentDir+"//Screenshots//"+System.currentTimeMillis()+".png"));
	}
}