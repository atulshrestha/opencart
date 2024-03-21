package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pajeObjects.HomePage;
import pajeObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartPageTest extends BaseClass{
	
	@Test(groups= {"master"})
	public void verify_addToCart() {
		logger.info("Starting TC_005_AddToCartPageTest ....... ");
		
		try {	
			HomePage hp = new HomePage(driver);
		
			hp.enterProductName("iPhone");	
			hp.clickSearch();
			logger.info(" Clicking SEARCH........ ");
		
			SearchPage sp =new SearchPage(driver);
		
			if(sp.isProductionExist("iPhone")) {
				sp.selectProduct("iPhone");
				logger.info("clicking iphone component ........... ");
				sp.setQuantity("2");
				logger.info(" Quantity value Resetted to 2 ..... ");
				sp.addToCart();
				logger.info("Clicked add to cart button .... ");
			}
			Assert.assertEquals(sp.checkConfMsg(),true);
			
		} catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC_005_AddToCartPageTest .......");
		
	}

}
