package com.badandbath.webdriver.pages.bedding.sheets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.badandbath.webdriver.pages.BasePage;

public class SheetSetsPage extends BasePage {
	/**
	 * Web element for first sheet.
	 */
	@FindBy(xpath="//img[@data-locator='product_tile_image']")
	private WebElement firstSheetSet;
	
	@FindBy(xpath="//button[text()='Quickview']")
	private WebElement quickView;
	
	@FindBy(xpath="//header[@data-locator='product_tile_title']/a/span")
	private WebElement produtTitle;

	public SheetSetsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public QuickViewPage clickOnFirstProductQuickView() {
		moveToElement(findClickable(firstSheetSet));
		findClickable(quickView).click();
		return new QuickViewPage(driver);
	}
	
	public String getProductTitle() {
		return produtTitle.getText();
	}
	

}
