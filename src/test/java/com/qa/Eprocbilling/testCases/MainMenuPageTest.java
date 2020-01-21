package com.qa.Eprocbilling.testCases;

import static org.testng.Assert.assertEquals;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.EprocBiling.listener.TestListner;
import com.qa.Eprocbilling.base.TestBase;
import com.qa.Eprocbilling.pages.MainMenu;
import com.qa.Eprocbilling.pages.loginPage;
import com.qa.Eprocbilling.utils.TestUtil;


@Listeners(TestListner.class)

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
	assertEquals(title,"kjwd");
	}
	@Test
	public void purchaseLinkTest() {
		
		mainmenu.validatePurchasesPageLink();
		assertEquals(true, false);
		//TestUtil.getScreenShot("AftervalidatePurchasesPageLink");
	}
	@Test
	public void salesLinkTest() {
		mainmenu.salesPageLinkTest();
		TestUtil.getScreenShot("AftersalesPageLinkTest");
	}
	@AfterMethod
	public  void tearDown() {
		driver.quit();
	}
}
