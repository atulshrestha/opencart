package pajeObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//img[@title='MacBook']")
	List<WebElement> searchProducts;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement txtQuantity;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnaddToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement cnfMsg;
	
	
	public boolean isProductionExist(String productName) {
		
		boolean flag= false;
		for(WebElement product:searchProducts) {
			if(product.getAttribute("title").equals(productName)) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	
	public void selectProduct(String productName) {
		
		for(WebElement product:searchProducts) {
			if(product.getAttribute("title").equals(productName)) {
				product.click();
			}
		}
	}
	
	
	public void setQuantity(String qty) {
		txtQuantity.clear();
		txtQuantity.sendKeys(qty);
	}
	
	public void addToCart()
	{
		btnaddToCart.click();
	}
	
	public boolean checkConfMsg()
	{
		try{
		return cnfMsg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
	
	
}
