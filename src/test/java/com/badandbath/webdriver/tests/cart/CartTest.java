package com.badandbath.webdriver.tests.cart;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.badandbath.webdriver.pages.bedding.BeddingPage;
import com.badandbath.webdriver.pages.bedding.sheets.QuickViewPage;
import com.badandbath.webdriver.pages.bedding.sheets.SheetSetsPage;
import com.badandbath.webdriver.pages.bedding.sheets.SheetsPage;
import com.badandbath.webdriver.pages.cart.CartPage;
import com.badandbath.webdriver.pages.cartsummary.CartSummaryPage;
import com.badandbath.webdriver.tests.BaseTest;
import com.badandbath.webdriver.utils.TestLogger;

public class CartTest extends BaseTest {
	
	private TestLogger log = TestLogger.getLogger(CartTest.class);

	@Test
	public void testProductIsAddedToCart() {
		log.logInfo("Mouse move on Products menu.");
		homePage.mouseMoveOnProductsMenu();
		
		log.logInfo("Click on bedding link.");
		BeddingPage beddingPage = homePage.clickOnBeddingLink();
		
		log.logInfo("Click on Sheets link.");
		SheetsPage sheetsPage = beddingPage.clickOnSheetsLink();
		
		log.logInfo("Click on Sheet sets.");
		SheetSetsPage sheetSets = sheetsPage.clickOnSheetSets();
		
		log.logInfo("Click on first product QuickView.");
		QuickViewPage quickViewPage = sheetSets.clickOnFirstProductQuickView();
		
		log.logInfo("Select sheet color as black.");
		String color = "BLACK";
		quickViewPage.selectSheetColor(color);
		
		log.logInfo("Select sheet size as queen.");
		String size = "QUEEN";
		quickViewPage.selectSheetSize(size);

		String productTitle = quickViewPage.getProductTitle();
		log.logInfo("Product title is "+" ====> "+productTitle);
		
		log.logInfo("Click on Add to cart button.");
		CartSummaryPage cartSummaryPage = quickViewPage.clickOnAddToCartbutton();
		
		log.logInfo("Click on View cart button.");
		CartPage cartPage = cartSummaryPage.clickOnViewCart();
		
		log.logInfo("Verify Selected product title is  displayed on cart page.");
		boolean isSelctedProductTitleDisplayedInCart = cartPage.isSelctedProductTitleDisplayedInCart(productTitle);
		Assert.assertTrue(isSelctedProductTitleDisplayedInCart,"Product title should be displayed, but it is not.");
		
		log.logInfo("Verify Selected product color is  displayed on cart page.");
		boolean isSelectedProductColorDisplayedInCart = cartPage.isSelectedProductColorDisplayedInCart(color);
		Assert.assertTrue(isSelectedProductColorDisplayedInCart,"Product color should be displayed, but it is not.");
		
		log.logInfo("Verify actual product size is expected product size on cart page.");
		String actualSize = cartPage.getProductSize();
		Assert.assertEquals(actualSize, size, "Actual product size "+actualSize+" is not matched with expected product size "+size);
	}
}
