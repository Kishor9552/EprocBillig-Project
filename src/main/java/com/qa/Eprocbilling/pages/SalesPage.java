package com.qa.Eprocbilling.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.Eprocbilling.base.TestBase;

public class SalesPage extends TestBase {
@FindBy(xpath="//div[@id='MainMenuDiv']//ul//li[@class='main_menu_selected']")
WebElement salesLink;
}
