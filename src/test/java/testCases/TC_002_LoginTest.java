package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pajeObjects.HomePage;
import pajeObjects.LoginPage;
import pajeObjects.MyAccountPage;
import testBase.BaseClass;




public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void verify_login() {
		
		logger.info("***** Starting TC_002_LoginTest");
		logger.debug("Capturing application debug logs......");
		
		try
		{
		//Homepage	
		HomePage hp = new HomePage(driver);
		
		logger.info("Clicking My Account drop-down");
		hp.clickMyAccount();
		
		logger.info("Clikcing Login from 'My Account' drop down");
		hp.clickLoginLink();
		
		
		//Login Page
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Filling up email address and password");
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin(); // Clicking login button
		
		logger.info("Clicked on Login button");
		
		
		// My Account page
		
		MyAccountPage macc = new MyAccountPage(driver);
		Boolean SuccessfulLogin = macc.isMyAccountPageExists();
		
		if(SuccessfulLogin == true)
		{
			logger.info("Successful login");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login Failed");
			Assert.fail();
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		
		logger.info("***** Finished TC_002_LoginTest ******");
	}
	
}
