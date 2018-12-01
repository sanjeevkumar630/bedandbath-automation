package com.badandbath.webdriver.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.badandbath.webdriver.pages.home.HomePage;
import com.badandbath.webdriver.utils.PropertyUtil;

public class BaseTest {

	protected WebDriver driver;

	public WebDriver getWebDriver() {
		String browser = PropertyUtil.getValue("driver");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resource\\binaries\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resource\\binaries\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	protected HomePage homePage;

	@BeforeTest
	public void setup() {
		driver = getWebDriver();
		String url = PropertyUtil.getValue("url");
		driver.get(url);
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		homePage.closePopupsIfPresent();
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
