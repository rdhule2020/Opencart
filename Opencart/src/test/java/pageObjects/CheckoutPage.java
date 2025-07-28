package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"content\"]/p")
	WebElement txt_cartmsg;
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	WebElement btn_continue;

	public void clickcontinue() {
		btn_continue.click();
	}

	public String getCartMsg() {
		try {
			return (txt_cartmsg.getText());
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
