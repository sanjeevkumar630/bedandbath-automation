package com.badandbath.webdriver.pages.bedding.sheets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.badandbath.webdriver.pages.BasePage;

public class SheetsPage extends BasePage {
	
	@FindBy(xpath="//p[text()='Sheet Sets']/../..")
	private WebElement sheetSetsLink;

	public SheetsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public SheetSetsPage clickOnSheetSets() {
		findClickable(sheetSetsLink).click();
		return new SheetSetsPage(driver);
	}

}
