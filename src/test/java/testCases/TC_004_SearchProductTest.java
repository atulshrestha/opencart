package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pajeObjects.HomePage;
import pajeObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void verify_productSearch() throws InterruptedException{
		logger.info("Starting TC_004_SearchProductTest");
	
		try {
			HomePage hm = new HomePage(driver);
			
			hm.enterProductName("mac");
			
			hm.clickSearch();
			
			SearchPage sp = new SearchPage(driver);
			sp.isProductionExist("MacBook");
			
			Assert.assertEquals(sp.isProductionExist("MacBook"), true);
			
			
		} catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC_004_SearchProductTest");
	}
}
