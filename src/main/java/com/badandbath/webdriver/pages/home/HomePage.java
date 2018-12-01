package com.badandbath.webdriver.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.badandbath.webdriver.pages.BasePage;
import com.badandbath.webdriver.pages.bedding.BeddingPage;
import com.badandbath.webdriver.utils.TestLogger;

public class HomePage extends BasePage {
	
	private TestLogger log = TestLogger.getLogger(HomePage.class);
	
	@FindBy(id="firstTopNavItem")
	private WebElement produtsMenu;
	
	@FindBy(linkText="Bedding")
	private WebElement beddingLink;
	
	private By closeButton = By.xpath("//button[@title='close']");

	private By closeButton2 = By.id("closeButton");

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void mouseMoveOnProductsMenu() {
		Actions actions = new Actions(driver);
		actions.moveToElement(produtsMenu).build().perform();
	}
	
	public BeddingPage clickOnBeddingLink() {
		findClickable(beddingLink).click();
		return new BeddingPage(driver);
	}
	
	public void closePopupsIfPresent() {
		if(isDisplayed(closeButton)) {
			log.logInfo("Close button is displayed.");
			findClickable(closeButton).click();
		}
		if(isDisplayed(closeButton2)) {
			log.logInfo("Close button2 is displayed.");
			findClickable(closeButton2).click();
		}
	}

}
