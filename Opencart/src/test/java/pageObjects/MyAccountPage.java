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
	
	//search
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement txtbox_search;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")WebElement btn_search;
	//search criteria
	@FindBy(xpath = "//input[@id='input-search']") WebElement txtbox_search1;
	//result page
	@FindBy(xpath ="//p[contains(text(),'There is no product that matches the search criter')]")WebElement resultmsg;
	
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
	
	public void send_search(String value) {
		txtbox_search.sendKeys(value);
	}
	
	public void clicksearch() {
		btn_search.click();
	}
	
	public String getText_txtbox_search1() {
		return txtbox_search1.getText();
	}
	public void clicksearch1() {
		txtbox_search1.click();
	}
	
	public String getresultmsg() {
		return resultmsg.getText();
	}
}
