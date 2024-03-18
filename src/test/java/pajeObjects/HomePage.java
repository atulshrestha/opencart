package pajeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}



	@FindBy(xpath= "//span[@class='caret']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath= "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	
	
	//Action Methods
	public void clickMyAccount()
	{
		lnkMyaccount.click();	
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLoginLink()
	{
	lnkLogin.click();
	}

}