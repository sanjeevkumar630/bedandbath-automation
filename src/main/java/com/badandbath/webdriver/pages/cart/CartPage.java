package com.badandbath.webdriver.pages.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.badandbath.webdriver.pages.BasePage;
import com.badandbath.webdriver.utils.TestLogger;

public class CartPage extends BasePage {

	TestLogger log = TestLogger.getLogger(CartPage.class);
	
	@FindBy(xpath="//span[text()='Size:']/following-sibling::span")
	private WebElement productSize;
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method to check whether selected product is displayed on cart.
	 * @param productTitle the product title.
	 * @return true/false, true if product title is displayed, else false.
	 */
	public boolean isSelctedProductTitleDisplayedInCart(String productTitle) {
		WebElement element = findClickable(By.linkText(productTitle));
		boolean isDisplayed = isDisplayed(element);
		log.logInfo("Is selected product title displayed in cart: "+isDisplayed);
		return isDisplayed;
	}
	
	public boolean isSelectedProductColorDisplayedInCart(String color) {
		String xpathString = "//span[text()='Color:']/following-sibling::span[text()='"+color.toLowerCase()+"']";
		boolean isDisplayed = isDisplayed(By.xpath(xpathString));
		log.logInfo("Is selected product color displayed in cart: "+isDisplayed);
		return isDisplayed;
	}
	
	public String getProductSize() {
		String productSize = this.productSize.getText();
		log.logInfo("Product size is: "+productSize);
		return productSize;
	}

}
