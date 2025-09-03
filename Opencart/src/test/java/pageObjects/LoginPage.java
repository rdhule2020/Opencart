package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
		public LoginPage(WebDriver driver)
		{
			super(driver);
			//PageFactory.initElements(driver, this);
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
		
//		public void login(String username, String password)
//		{
//			enterText(txtEmailAddress,username );
//			enterText(txtPassword,password);
//			clickElement(btnLogin);
//		}
}
