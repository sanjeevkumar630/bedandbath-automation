package com.badandbath.webdriver.pages.bedding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.badandbath.webdriver.pages.BasePage;
import com.badandbath.webdriver.pages.bedding.sheets.SheetsPage;

public class BeddingPage extends BasePage {

	@FindBy(linkText="Sheets")
	private WebElement sheetsLink;
	
	public BeddingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public SheetsPage clickOnSheetsLink() {
		findClickable(sheetsLink).click();
		return new SheetsPage(driver);
	}
}
