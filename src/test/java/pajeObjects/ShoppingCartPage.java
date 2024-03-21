package pajeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		}
	
	
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//strong[normalize-space()='Total:']")
	WebElement lblTotalPrice;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnCheckout;
	
	
	public void clickbtnItems() {
		btnItems.click();
	}
	
	public void clicklnkViewCart() {
		btnItems.click();
	}
	
	public String getTotalPrice() {
		return lblTotalPrice.getText();
	}
	
	public void clickbtnCheckout() {
		btnCheckout.click();
	}
	

}
