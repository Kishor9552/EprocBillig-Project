package com.qa.Eprocbilling.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Eprocbilling.base.TestBase;
import com.qa.Eprocbilling.pages.MainMenu;
import com.qa.Eprocbilling.pages.loginPage;

public class MainMenuPageTest extends TestBase{
public static loginPage loginpage;
public static MainMenu mainmenu;

	public MainMenuPageTest() {
		super();
	}
	@BeforeMethod
	public  void setUp() {
		initialisation();
		loginpage=new loginPage();
		loginpage.validatevalidLogin();
		mainmenu=new MainMenu();
		
	}
	@Test
	public  void menupagetitleTest() {
		
	String title=	mainmenu.validateMenuPagetitle();
	System.out.println(title);
	}
	@Test
	public void purchaseLinkTest() {
		mainmenu.validatePurchasesPageLink();
	}
	@Test
	public void salesLinkTest() {
		mainmenu.salesPageLinkTest();
	}
	@AfterMethod
	public  void tearDown() {
		//driver.quit();
	}
}
