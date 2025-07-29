package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class AddressBookPage extends BasePage {

	public AddressBookPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-default']")WebElement btn_back;
	@FindBy(xpath = "//a[@class='btn btn-primary']")WebElement btn_NewAddress;
	@FindBy(xpath = "//input[@id='input-firstname']")WebElement txt_firstName;
	@FindBy(xpath = "//input[@id='input-lastname']")WebElement txt_lastName;
	@FindBy(xpath = "//input[@id='input-company']")WebElement txt_company;
	@FindBy(xpath = "//input[@id='input-address-1']")WebElement txt_Address1;
	@FindBy(xpath = "//input[@id='input-address-2']")WebElement txt_Address2;
	@FindBy(xpath = "//input[@id='input-city']")WebElement txt_city;
	@FindBy(xpath = "//input[@id='input-postcode']")WebElement txt_postcode;
	@FindBy(xpath = "//select[@id='input-country']")WebElement drp_Country;
	@FindBy(xpath = "//select[@id='input-zone']")WebElement drp_region_State;
	@FindBy(xpath = "//input[@checked='checked']")WebElement radiobtn;
	@FindBy(xpath = "//input[@class='btn btn-primary']")WebElement btn_continue;
	
	//Edit_delete Address Book
	@FindBy(xpath ="//tbody/tr/td[1]/a[1]")WebElement btn_Edit;
	@FindBy(xpath ="//tbody/tr/td[1]/a[1]")WebElement btn_Delete;
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement AddressSuccessMsg;
	public void clickBack() {
		btn_back.click();
	}
	
	public void clickNewAddress() {
		btn_NewAddress.click();
	}
	
	public void sendfirstName(String value) {
		txt_firstName.sendKeys(value);
	}
	
	public void sendlastName(String value) {
		txt_lastName.sendKeys(value);
	}
	
	public void sendcompany(String value) {
		txt_company.sendKeys(value);
	}
	
	public void sendAddress1(String value) {
		txt_Address1.sendKeys(value);
	}
	public void sendAddress2(String value) {
		txt_Address2.sendKeys(value);
	}
	
	public void sendCity(String city) {
		txt_city.sendKeys(city);
	}
	
	public void sendPostCode(String value)
	{
		txt_postcode.sendKeys(value);
	}
	
	public void selectCountry(String country) {
		WebElement option = driver.findElement(By.xpath("//select[@id='input-country']"));
		
		Select select = new Select(option);
		select.selectByVisibleText(country);
	}
	
	public void selectZone(String zone){
		WebElement state = driver.findElement(By.xpath("//select[@id='input-zone']"));
		
		Select select = new Select(state);
		select.selectByVisibleText(zone);
	}
	
	public void checkstatus() {
		radiobtn.isDisplayed();
	}
	
	public void clickcontinue() {
		btn_continue.click();
	}
	//Edit_delete Address Book
	
	public void clickDelete() {
		btn_Delete.click();
	}
	
	public String AddressSuccessMsg() {
		return AddressSuccessMsg.getText();
	}


}
