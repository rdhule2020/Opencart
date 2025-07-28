package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountInformationPage extends BasePage {

	public MyAccountInformationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastName;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@name='telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement btnBack;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg;

	public void clearfirstName() {
		firstName.clear();
	}

	public void setfirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public String getlname() {
		return (lastName.getText());
	}

	public void clearlastName() {
		lastName.clear();
	}

	public void setlname(String lname) {
		lastName.sendKeys(lname);
	}

	public String getemail() {
		return (email.getText());
	}

	public String gettelephone() {
		return (telephone.getText());
	}

	public void clickContinue() {
		btncontinue.click();
	}

	public void clickback() {
		btnBack.click();
	}

}
