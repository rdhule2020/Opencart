package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAddressPage extends BasePage {
	public EditAddressPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * //input[@id='input-firstname'] //input[@id='input-lastname']
	 * //input[@id='input-company'] //input[@id='input-address-1']
	 * //input[@id='input-address-2'] //input[@id='input-city']
	 * //input[@id='input-postcode'] //select[@id='input-country']
	 * //select[@id='input-zone'] //input[@value='Continue']
	 * 
	 * success msg === > //div[@class='alert alert-success alert-dismissible']
	 */
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_firstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastName;
	@FindBy(xpath = "//input[@id='input-company']")
	WebElement txt_company;
	@FindBy(xpath = " //input[@id='input-address-1']")
	WebElement txt_Address1;
	@FindBy(xpath = "//input[@id='input-address-2']")
	WebElement txt_Address2;
	@FindBy(xpath = "//input[@id='input-city'] ")
	WebElement txt_city;
	@FindBy(xpath = "//input[@id='input-postcode']")
	WebElement txt_postcode;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_EditSuccess;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_continue;

	public void clearFirstName() {
		txt_firstName.clear();
	}

	public void clearlastName() {
		txt_lastName.clear();
	}

	public void clearCompany() {
		txt_company.clear();
	}

	public void clearAddress1() {
		txt_Address1.clear();
	}

	public void clearAddress2() {
		txt_Address2.clear();
	}

	public void clearCity() {
		txt_city.clear();
	}

	public void clearpostcode() {
		txt_postcode.clear();
	}

	public void clickContinue() {
		btn_continue.click();
	}

	public String getmsg() {
		return (msg_EditSuccess.getText());
	}
}
