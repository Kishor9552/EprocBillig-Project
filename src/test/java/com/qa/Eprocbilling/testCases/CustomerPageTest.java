package com.qa.Eprocbilling.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.Eprocbilling.base.TestBase;
import com.qa.Eprocbilling.pages.CustomerPage;
import com.qa.Eprocbilling.pages.MainMenu;
import com.qa.Eprocbilling.pages.loginPage;
import com.qa.Eprocbilling.utils.TestUtil;

public class CustomerPageTest extends TestBase{
	public static loginPage loginpage;
	public static MainMenu mainmenupage;
	public static CustomerPage customerpage;
	
	public CustomerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		loginpage=new loginPage();
		loginpage.validatevalidLogin();
		mainmenupage=new MainMenu();
		mainmenupage.validatecustomerpageLink();
		customerpage=new CustomerPage();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@DataProvider
	public Object[][] getCustomerData() {
		Object [][] data= TestUtil.getTestData("customerDetails");
		return data;
	}
	@Test(dataProvider="getCustomerData")
	public void customerpageTest(String custcode, String custname, String custaddres, String custpostlcode,
			String custcountry, String salestype, String currency){
		customerpage.insertCustomerDetail(custcode, custname, custaddres, custpostlcode, custcountry, salestype, currency);
	}
	

}
