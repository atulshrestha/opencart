package pajeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		}
	
	
	
	@FindBy(xpath="//div[@id='cart']")
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td")
	WebElement lblTotalPrice;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnCheckout;
	
	
	public void clickbtnItems() {
		btnItems.click();
	}
	
	public void clicklnkViewCart() {
		lnkViewCart.click();
	}
	
	public String getTotalPrice() {
		return lblTotalPrice.getText();
	}
	
	public void clickbtnCheckout() {
		btnCheckout.click();
	}
	

}
