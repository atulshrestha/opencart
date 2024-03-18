package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pajeObjects.AccountRegistrationPage;
import pajeObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration() 
	{
		logger.info("***** starting TC_001_AccountRegistrationTest ***** ");
		logger.debug("Application logs.......");
		try
		{
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*****Clicked on My Account link*****");
		hp.clickRegister();
		logger.info("*****Clicked on My Register link*****");
		
		
		logger.info("*****Entering user registration details*****");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAplhaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.checkPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		
		String confmsg = regpage.getConfirmationMsg();
		
		logger.info("Validating confirmation message");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("!!!!!!!! Test Passed !!!!!!!!");
			AssertJUnit.assertTrue(true);
		}
		else {
			logger.error("!!!!!!!! Test Failed !!!!!!!!");
			Assert.fail();
		}
		
		}
		catch(Exception e) 
		{
			logger.error("!!!!! Test Failed !!!!!");
			logger.debug("debug logs......");
			Assert.fail();
		}
		
		logger.info("***** Finished TC_001_AccountRegistrationTest Execution *****");
		
	}
	
	
	
	
	
	
	
	
}
