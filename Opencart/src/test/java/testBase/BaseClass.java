package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;//Log4j
import org.apache.logging.log4j.Logger;//Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

	public static WebDriver driver;
	public Logger logger; //Log4j
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"OS","Browser"})
	public void setup(String OS, String br  ) throws IOException 
	{
	 //loading config.properties file
	FileReader file = new FileReader("./src/test/resources//config.properties");	
		p = new Properties();
		p.load(file);

	//Logger log4j	
	logger = LogManager.getLogger(this.getClass());
	
	switch(br.toLowerCase())
	{
	case "chrome" :  driver = new ChromeDriver();	break;
	case "edge" :  driver = new EdgeDriver();	break;
	case "firefox" : driver = new FirefoxDriver(); break;
	default : System.out.println("Invalid browser name..."); return;
	}
	
	 driver = new EdgeDriver();	
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.get(p.getProperty("appURL"));
	 driver.manage().window().maximize();
	}

	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String randomNumber = RandomStringUtils.randomNumeric(3);
		
		return (generatedstring+"$"+randomNumber);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
