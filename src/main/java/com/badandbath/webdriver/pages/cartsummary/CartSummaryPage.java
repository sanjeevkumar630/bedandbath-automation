package com.badandbath.webdriver.pages.cartsummary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.badandbath.webdriver.pages.BasePage;
import com.badandbath.webdriver.pages.cart.CartPage;

public class CartSummaryPage extends BasePage {

	@FindBy(linkText = "View Cart & Checkout")
	WebElement viewCart;
	
	public CartSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public CartPage clickOnViewCart() {
		findClickable(viewCart).click();
		return new CartPage(driver);
	}

}
