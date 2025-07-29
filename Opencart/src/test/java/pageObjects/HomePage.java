package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) 
	{
		
		super(driver);
	
	}
	
	@FindBy(xpath ="//span[normalize-space()='My Account']") WebElement likMyAccount;
	@FindBy(xpath ="//a[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(linkText ="Login") WebElement lnkLogin; // Login link added in steps
	@FindBy(xpath ="//*[@id=\"top-links\"]/ul/li[5]/a/span") WebElement btn_checkout;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[1]//span[1]") WebElement btn_MacBook;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[1]")WebElement btn_mac_Addtocart;
	@FindBy(xpath= "//div[@class='alert alert-success alert-dismissible']")WebElement successaddcartmsg; 
	@FindBy(xpath= "//span[normalize-space()='Shopping Cart']") WebElement btn_shoppingcart;
	@FindBy(xpath ="//button[@class='btn btn-danger']") WebElement btn_remove;
	
	public void clickMyAccount() {
		likMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin()    
	{
		lnkLogin.click();
	}
	
	public void clickcheckout() {
		btn_checkout.click();
	}
	
	public void clickMacBook() {
		btn_MacBook.click();
	}
	
	public void clickmac_Addtocart()
	{
		btn_mac_Addtocart.click();
	}
	
	public String getsuccescartmsg()
	{
		return(successaddcartmsg.getText());
	}
	public void clickshoppingcart()
	{
		btn_shoppingcart.click();
	}
	
	public void clickremove() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", btn_remove);
		
	}
}
