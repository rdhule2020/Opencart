package pageObjects;

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
}
