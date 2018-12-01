package com.badandbath.webdriver.pages.bedding.sheets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.badandbath.webdriver.pages.BasePage;
import com.badandbath.webdriver.pages.cartsummary.CartSummaryPage;

public class QuickViewPage extends BasePage {
	
//	@FindBy(xpath="//button[@title='BLACK']")
//	private WebElement color;
	

//	@FindBy()
//	private WebElement size;


	@FindBy(xpath="//button[text()='Add to Cart']")
	private WebElement addToCart;
	
	//"//h1[contains(@class,'ProductDetails')]/a
	
	@FindBy(xpath="//h1[contains(@class,'ProductDetails')]/a")
	private WebElement productTitle;
	
	public QuickViewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectSheetColor(String color) {
		String xpathString =" //button[@title='"+color+"']";
		findClickable(By.xpath(xpathString)).click();
	}
	
	public void selectSheetSize(String size) {
		String xpathString =" //button/span[text()='"+size+"']";
		findClickable(By.xpath(xpathString)).click();
	}
	
	public String getProductTitle() {
		return findClickable(productTitle).getText();
	}
	
	public CartSummaryPage clickOnAddToCartbutton() {
		findClickable(addToCart).click();
		return new CartSummaryPage(driver);
	}

}
