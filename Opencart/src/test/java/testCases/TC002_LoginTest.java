package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	
	@Test(groups={"Sanity","Master"})
	public void verify_Login() 
	{
		logger.info("****Starting TC002_LoginTest****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//HomePage
		LoginPage lp = new LoginPage(driver);
//		lp.login(p.getProperty("email"), p.getProperty("password"));
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage ap = new MyAccountPage(driver);
		boolean trgpage =ap.isMyAccountPageExists();
		Assert.assertEquals(trgpage, true, "Login failed");
		//Assert.assertTrue(trgpage)

		}catch(Exception e) 
		{
			Assert.fail();
		}
		
		
		logger.info("****Finished TC002_LoginTest****");
		
	};
	

	
}
