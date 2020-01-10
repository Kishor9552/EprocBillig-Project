package com.qa.Eprocbilling.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Eprocbilling.base.TestBase;

public class loginPage extends TestBase {

	@FindBy(xpath = "//input[@name='UserNameEntryField']")
	WebElement username;
	@FindBy(xpath = "//input[@name='Password']")
	WebElement pass;
	@FindBy(css = "input.button")
	WebElement loginbtn;
	@FindBy(xpath="//div[@id='demo_text']")
	WebElement errorMassage;
	/*@FindBy(css = "div#demo_text>b:first-of-type")
	WebElement invalidPassText;*/
	@FindBy(css="#login_logo")
	WebElement loginpageLogo;

	public loginPage() {
		PageFactory.initElements(driver, this);
	}

	
	
	public String validateLoginPagetitle() {
		return driver.getTitle();

	}

	public MainMenu validatevalidLogin() {
		username.sendKeys(prop.getProperty("validuserName"));
		pass.sendKeys(prop.getProperty("validpassword"));
		loginbtn.click();
		return new MainMenu();
		
	}

	public void validateInvalidLoginDetails() {
		username.sendKeys(prop.getProperty("invalidusername"));
		pass.sendKeys(prop.getProperty("invalidpassword"));
		loginbtn.click();

	}

	public String validateinvalidpassword() {
		username.sendKeys(prop.getProperty("validuserName"));
		pass.sendKeys(prop.getProperty("invalidpassword"));
		loginbtn.click();
		return errorMassage.getText();	
	}
	public boolean validateLoginPageLogo() {
		return loginpageLogo.isDisplayed();
	}
}
