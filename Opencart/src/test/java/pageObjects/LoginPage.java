package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
		public LoginPage(WebDriver driver)
		{
			super(driver);
		}
		
		@FindBy(xpath = "//input[@placeholder='E-Mail Address']") WebElement txtEmailAddress;
		@FindBy(xpath ="//input[@placeholder='Password']") WebElement txtPassword;
		@FindBy(xpath="//input[@type='submit']") WebElement btnLogin;
		
		
		public void setEmail(String email)
		{
			txtEmailAddress.sendKeys(email);
		}
		
		public void setPassword(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		
		public void clickLogin()
		{
			btnLogin.click();
		}
}
