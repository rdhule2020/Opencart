package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement btnlogout;
	// @FindBy(xpath="//span[normalize-space()='My Account']")WebElement
	// btnMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")WebElement editAccInfo;
	
	
	
	public boolean isMyAccountPageExists() {
		try {
			boolean status = msgHeading.isDisplayed();
			return (status);
			// return(msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}

//	 public void clickMyAccount()
//	 {
//		 btnMyAccount.click();
//	 }
//	 
	public void clickLogout() {
		btnlogout.click();
	}

	public void clickeditAccInfo() 
	{
		editAccInfo.click();
	}
}
