package com.qa.Eprocbilling.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.Eprocbilling.base.TestBase;

public class TestUtil extends TestBase {
	public static long pageLoadTimeOut = 20;
	public static long implicitwait = 50;
	public static Workbook book;
	public static Sheet sheet;
	public static String pathOfxlFile = "";

	public static void getScreenShot(String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File("./screenshot2/eprocbilling" + screenshotname + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream("C:\\Users\\Shree\\Desktop\\Alleclipse\\Eprocbilling\\src\\main"
					+ "\\java\\com\\qa\\Eprocbilling\\testData\\customerDetails.xlsx");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("customerDetails");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}
