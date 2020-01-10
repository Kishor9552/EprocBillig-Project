package com.qa.Eprocbilling.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.Eprocbilling.base.TestBase;

public class TestUtil extends TestBase {
	public static long pageLoadTimeOut = 20;
	public static long implicitwait = 50;



	public static void getScreenShot(String methodname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src,
				new File("D:\\Eprocbiling\\ScreenShot\\" + methodname + "_" + System.currentTimeMillis() + ".jpg"));
	}
}