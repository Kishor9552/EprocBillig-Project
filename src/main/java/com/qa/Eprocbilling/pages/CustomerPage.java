package com.qa.Eprocbilling.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Eprocbilling.base.TestBase;

public class CustomerPage extends TestBase {
	// Add a New Customer
	@FindBy(linkText = "Add a New Customer")
	WebElement AddaNewCustomerLink;

	@FindBy(xpath = "//input[@name='DebtorNo']")
	WebElement customerCode;

	@FindBy(xpath = "//input[@name='CustName']")
	WebElement customerName;

	@FindBy(xpath = "//input[@name='Address1']")
	WebElement customerAddress;

	@FindBy(xpath = "//input[@name='Address5']")
	WebElement customerAddressPostalcode;

	@FindBy(xpath = "//select[@name='Address6']")
	WebElement selectCountry;

	@FindBy(xpath = "//select[@name='SalesType']")
	WebElement selectSalesType;

	@FindBy(xpath = "//div[@id='calendar']//table//tr[5]//td[5]")
	WebElement selectdate;

	@FindBy(xpath = "//select[@name='CurrCode']")
	WebElement selectCurrency;

	public CustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public void insertCustomerDetail(String custcode, String custname, String custaddres, String custpostlcode,
			String custcountry, String salestype, String currency) {
		AddaNewCustomerLink.click();
		customerCode.sendKeys(custcode);
		customerName.sendKeys(custname);
		customerAddress.sendKeys(custaddres);
		customerAddressPostalcode.sendKeys(custpostlcode);

		Select select1 = new Select(selectCountry);
		select1.selectByVisibleText(custcountry);

		Select select2 = new Select(selectSalesType);
		select2.selectByVisibleText(salestype);

		selectdate.click();

		Select select3 = new Select(selectCurrency);
		select3.selectByVisibleText(currency);
	}

}
