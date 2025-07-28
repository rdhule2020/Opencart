package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked My Account link..");
		hp.clickRegister();
		logger.info("Clicked Register link..");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details..");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmailID(randomString()+"@gmail.com");
		regpage.setTelephone("randomNumber()");
		
		String password = randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating Expected message..");
		String confirmmsg  = regpage.getConfirmationMsg();
		if(confirmmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("Debug Logs...");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		finally {
		logger.info("Finished TC001_AccountRegistrationTest..");
		}
	}
	

}
