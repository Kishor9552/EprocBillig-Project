package com.qa.Eprocbilling.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import com.qa.EprocBiling.listener.Mylistener;
import com.qa.Eprocbilling.utils.TestUtil;

public class TestBase {
	public static Properties prop;
	public static final String propFilepath = "C:\\Users\\Shree\\Desktop\\Alleclipse\\Eprocbilling\\src\\main\\java\\com\\qa\\Eprocbilling\\config\\config.properties";
	public static final String pathOfChromeDriver = "C:\\\\Users\\\\Shree\\\\Desktop\\\\Alleclipse\\\\Eprocbilling\\\\src\\\\main\\\\java\\\\com\\\\qa\\\\Eprocbilling\\\\browsersDriver\\\\chromedriver.exe";
	public static final String PathOfLogFile = "C:\\Users\\Shree\\Desktop\\Alleclipse\\Eprocbilling\\src\\main\\resources\\log4j.properties";

	public static WebDriver driver;
	public static FileInputStream fis;
	public static EventFiringWebDriver edriver;
	public static org.apache.log4j.Logger log;

	public TestBase() {
		prop = new Properties();
		try {
			fis = new FileInputStream(propFilepath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void initialisation() {
		log = org.apache.log4j.Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure(PathOfLogFile);

		String BrowseName = prop.getProperty("browsername");
		if (BrowseName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pathOfChromeDriver);
			log.info("****Launching Chrome Browser****");
			driver = new ChromeDriver();
		} else if (BrowseName.equals("FF")) {
			System.setProperty("webdriver.chrome.driver", " ");
			driver = new FirefoxDriver();

		}

		edriver = new EventFiringWebDriver(driver);
		Mylistener ml = new Mylistener();
		edriver.register(ml);
		edriver.manage().window().maximize();
		edriver.manage().deleteAllCookies();
		edriver.manage().timeouts().pageLoadTimeout(com.qa.Eprocbilling.utils.TestUtil.pageLoadTimeOut,
				TimeUnit.SECONDS);
		edriver.manage().timeouts().implicitlyWait(com.qa.Eprocbilling.utils.TestUtil.implicitwait, TimeUnit.SECONDS);
		log.info("*****Opening Url*****");
		edriver.get(prop.getProperty("url"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
