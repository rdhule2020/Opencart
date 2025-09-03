 package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	protected WebDriverWait wait;
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		//this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

//	// Generic method for clicking
//	public void clickElement(WebElement element)
//	{
//		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//	}
//	
//	//Generic Method for entering text	
//	public void enterText(WebElement element, String text)
//	{
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		element.clear();
//		element.sendKeys(text);
//	}
//	
//	//Generic method for getting text
//	
//	public String getText(WebElement element)
//	{
//	wait.until(ExpectedConditions.visibilityOf(element));
//		return element.getText();
//	}
//	
//	//Generic method for checking element is displayed
//	public boolean isElementDisplayed(WebElement element)
//	{
//		try {
//		wait.until((ExpectedConditions.visibilityOf(element)));
//		return element.isDisplayed();
//		}catch(Exception e)
//		{
//			return false;
//		}
//	}
//	

}
 