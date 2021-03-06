package com.qa.Eprocbilling.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Eprocbilling.base.TestBase;
import com.qa.Eprocbilling.pages.loginPage;
import com.qa.Eprocbilling.utils.TestUtil;

public class LoginPageTest extends TestBase{
	loginPage loginpage;
    
	
	public LoginPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialisation();
		loginpage =new loginPage();
		
	}
	@Test()
	public void LoginPagetitleTest() {
		log.info("**Running loginpage Title Test**");
		loginpage.validateLoginPagetitle();
		TestUtil.getScreenShot("TitleOfLoginPage");
		String title=driver.getTitle();
		System.out.println(title);
		assertEquals(title, "webERP Login screen");
		
	}
	@Test(enabled=true)
	public void validloginPageTest() {
		log.info("**Running loginpage validLoginDetails Test**");
		loginpage.validateLoginPagetitle();
		TestUtil.getScreenShot("AfterValidatingLoginPageTitle");
	}
	@Test(enabled=true)
	public void invalidLoginPageTest() {
		log.info("**Running loginpage invalid loginDetails Test**");
		loginpage.validateInvalidLoginDetails();
		TestUtil.getScreenShot("AftervalidateInvalidLoginDetails");
	}
	@Test
	public void invalidpasswordTest() {
		log.info("**Running loginpage invalidpasswordTest Test**");
	String Text2=	loginpage.validateinvalidpassword();
	TestUtil.getScreenShot("Aftervalidateinvalidpassword");
	Assert.assertEquals(Text2, "incorrect password\r\n" + 
			"The user/password combination\r\n" + 
			"is not a valid user of the system");
	
		
			
			
	}
	@Test
	public void logoTest() {
		log.info("**Running loginpage logo Test**");
	boolean logo=	loginpage.validateLoginPageLogo();
		Assert.assertEquals(true, logo);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
