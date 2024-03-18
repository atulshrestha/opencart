package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pajeObjects.HomePage;
import pajeObjects.LoginPage;
import pajeObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	
	@Test(dataProvider = "LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) 
	{
		logger.info("****** Starting TC_003_LoginDDT *****");
		
		
		try {
		//Homepage	
		HomePage hp = new HomePage(driver);
				
		logger.info("Clicking My Account drop-down");
		hp.clickMyAccount();
				
		hp.clickLoginLink();
				
				
		//Login Page
		LoginPage lp = new LoginPage(driver);
				
		logger.info("Filling up email address and password");
				
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin(); // Clicking login button
				
		logger.info("Clicked on Login button");
				
				
		// My Account page
				
		MyAccountPage macc = new MyAccountPage(driver);
		Boolean SuccessfulLogin = macc.isMyAccountPageExists();
		
		
		if (exp.equalsIgnoreCase("Valid")) {
			if(SuccessfulLogin = true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")){
			if(SuccessfulLogin == true) {
				macc.clickLogout();
				Assert.assertTrue(false);
				}
			else{
				Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			Assert.fail();
			
		}
		logger.info("****** TC_003_LoginDDT Completed ******");
		
	}
		
}
