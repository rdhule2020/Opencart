package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
/*
 * Data is valid - login sucess - test pass -logout
 * Data is valid - login failed - test fail
 * 
 * Data is invalid - login success - test fail - logout
 * Data is invalid - login failed  - test pass
 */


public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "Login", dataProviderClass= DataProviders.class,groups="DataDriven") //Getting dataProvider from different class
	public void verify_LoginDDT(String username, String password, String res)
	{
		logger.info("*****Starting TC003_LoginDDT*****");
		try {
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
	
		//Login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean trgpage = macc.isMyAccountPageExists();
		
		if(res.equalsIgnoreCase("Valid")) 
		{
			if(trgpage==true)
			{	hp.clickMyAccount();
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		if(res.equalsIgnoreCase("Invalid")) 
		{

			if(trgpage==true)
			{	hp.clickMyAccount();
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Ending TC003_LoginDDT*****");
	}
	
}
