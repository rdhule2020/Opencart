package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MP3PlayerPage extends BasePage{

	public MP3PlayerPage(WebDriver driver) {
		super(driver);
		
	}
	/*sort By  -//select[@id='input-sort']
	 *products - //div[@class='product-layout product-list col-xs-12'] 
	 * show - //select[@id='input-limit']
	 * successmsg - //div[@class='alert alert-success alert-dismissible']
	 * 
	 * Title -//a[normalize-space()='iPod Nano']
	 * ipodnano -//button[@onclick="cart.add('36', '1');"] 
	 *Success: You have added iPod Nano to your shopping cart!
	 *
	 *Title -//a[normalize-space()='iPod Classic']
	 * ipod clcsic -//button[@onclick="cart.add('48', '1');"]
	 * Success: You have added iPod Classic to your shopping cart!
	 * 
	 * title-//a[normalize-space()='iPod Shuffle']
	 * ipod shuffle -//button[@onclick="cart.add('34', '1');"]
	 * Success: You have added iPod Shuffle to your shopping cart!
	 * 
	 * Title-//a[normalize-space()='iPod Touch']
	 * ipod touch - //button[@onclick="cart.add('32', '1');"]
	 * Success: You have added iPod Touch to your shopping cart!
	 */
	
	//Locators
	@FindBy(xpath ="//select[@id='input-sort']")WebElement drp_SortBy;
	@FindBy(xpath ="//div[@class='product-layout product-list col-xs-12']")WebElement products;
	@FindBy(xpath ="//select[@id='input-limit']")WebElement drp_Show;
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement txt_successmsg;
	
	@FindBy(xpath = "//a[normalize-space()='iPod Nano']")WebElement title_Nano;
	@FindBy(xpath = "//button[@onclick=\"cart.add('36', '1');\"]")WebElement btn_ipodnano;
	//@FindBy(xpath = "")WebElement msgNano;
	String namoMsg = "Success: You have added iPod Nano to your shopping cart!";
	
	@FindBy(xpath = "//a[normalize-space()='iPod Classic']")WebElement title_Classic;
	@FindBy(xpath = "//button[@onclick=\"cart.add('48', '1');\"]")WebElement btn_classic;
	//@FindBy(xpath = "")WebElement ;
	String classicMsg ="Success: You have added iPod Classic to your shopping cart!";
	
	@FindBy(xpath = "//a[normalize-space()='iPod Shuffle']")WebElement title_Shuffle;
	@FindBy(xpath = "//button[@onclick=\"cart.add('34', '1');\"]")WebElement btn_shuffle;
	//@FindBy(xpath = "")WebElement ;
	String shuffleMsg = "Success: You have added iPod Shuffle to your shopping cart!";
	
	@FindBy(xpath = "//a[normalize-space()='iPod Touch']")WebElement title_Touch;
	@FindBy(xpath = "//button[@onclick=\"cart.add('32', '1');\"]")WebElement btn_touch;
	//@FindBy(xpath = "")WebElement ;
	String touchMsg = "Success: You have added iPod Touch to your shopping cart!";
	
	//Methods
	
	public void sortBy(String value)
	{
		Select select = new Select(drp_SortBy);
		select.selectByVisibleText(value);;
	}
	
	public void show(String value)
	{
		Select select = new Select(drp_Show);
		select.selectByVisibleText(value);
	}
	
	public String getSuccessmsg()
	{
		return txt_successmsg.getText();
	}
	
	//product list handeling method
	public void selectProduct(WebElement products, String value) {
		
		Select list_products = new Select(products);
		List<WebElement> Alloptions = list_products.getOptions();
		for(WebElement option: Alloptions) {
			if(option.getText().equals(value)){
				option.click();
				break;
			}
		}
	}
	
	// Taken from copilot
//	public void selectProduct(String value) {
//	    // Locate the actual <select> element inside the products container
//	    WebElement dropdown = products.findElement(By.tagName("select"));
//
//	    // Create Select object
//	    Select list_products = new Select(dropdown);
//
//	    // Select the desired option
//	    list_products.selectByVisibleText(value);
//	}
	
//	
//	public <T extends WebElement> void interactWithElements(List<T> elements, Consumer<T> action) {
//	    for (T element : elements) {
//	        if (element.isDisplayed()) {
//	            action.accept(element);
//	        }
//	    }
//	}
//	//Use like this in test cases  --> //interactWithElements(products, WebElement::click);
	
	
	//Locator for iPodNano
	public String gettitleNano() {
		return title_Nano.getText();
	}
	public void clickipodnano() {
		btn_ipodnano.click();
	}
	
	//Locator for iPod Classic
	public String gettitleClassic() {
		return title_Classic.getText();
	}
	public void clickipodclassic() {
		btn_classic.click();
	}
	
	//Locator for iPod Shuffle
	public String gettitleshuffle() {
		return title_Shuffle.getText();
	}
	public void clickipodshuffle() {
		btn_shuffle.click();
	}
	
	//Locator for iPod Touch
	public String gettitleTouch() {
		return title_Touch.getText();
	}
	public void clickipodtouch() {
		btn_touch.click();
	}
}
