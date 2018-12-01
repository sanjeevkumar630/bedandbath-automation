package com.badandbath.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public WebElement findClickable(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return webElement;
	}
	
	public WebElement findClickable(By by){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(by));
		return webElement;
	}
	
	public WebElement findVisibleElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return webElement;
	}
	
	public WebElement findVisibleElement(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return webElement;
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean isDisplayed(By by) {
		try {
			return findVisibleElement(by, 60).isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
	
	public void closeWithJs(WebElement element) {
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", element);
	}

}
