package com.qa.Eprocbilling.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.Eprocbilling.base.TestBase;

public class MainMenu extends TestBase{
	@FindBy(xpath="//div[@id='MainMenuDiv']//ul//li[@class='main_menu_selected']")
	WebElement salesPageLink;
	
	@FindBy(linkText="Receivables")
	WebElement receivablesPageLink;
	
	@FindBy(linkText="Purchases")
	WebElement purchasesPageLink;
	
	@FindBy(linkText="Payables")
	WebElement PayablesPageLink;
	
	@FindBy(linkText="Inventory")
	WebElement InventoryPageLink;
	
	@FindBy(linkText="Manufacturing")
	WebElement ManufacturingPageLink;
	
	@FindBy(linkText="Setup")
	WebElement SetupPageLink;
	
	@FindBy(linkText="Utilities")
	WebElement UtilitiesPageLink;
	
	@FindBy(linkText="Customers")
	WebElement CustomersPageLink;
	

public MainMenu() {
	PageFactory.initElements(driver, this);
}
	public static String validateMenuPagetitle() {
		return driver.getTitle();
	}
	public PurchasePage validatePurchasesPageLink() {
		purchasesPageLink.click();
		return new PurchasePage();
	}
	public  SalesPage salesPageLinkTest() {
		salesPageLink.click();
		return new SalesPage();
	}
	public CustomerPage validatecustomerpageLink() {
		CustomersPageLink.click();
		return new CustomerPage();
		
	}
		
	}

