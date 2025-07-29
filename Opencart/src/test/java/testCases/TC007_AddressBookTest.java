package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AddressBookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC007_AddressBookTest extends BaseClass {
	
	@Test
	public void verifyAddressBookPage()
	{
		
		logger.info("***** Started Executing TC007_AddressBookTest *****");
		try {
		HomePage h = new HomePage(driver);
		h.clickMyAccount();
		h.clickLogin();
		
		LoginPage l = new LoginPage(driver);
		l.setEmail(p.getProperty("email"));
		l.setPassword(p.getProperty("password"));
		l.clickLogin();
		
		MyAccountPage ma = new MyAccountPage(driver);
		ma.clickAddressbook();
		logger.info("***** Entering data in AddressBook *****");
		AddressBookPage addBk = new AddressBookPage(driver);
		addBk.clickBack();
		ma.clickAddressbook();
		addBk.clickNewAddress();
		addBk.sendfirstName(p.getProperty("firstName"));
		addBk.sendlastName(p.getProperty("lastName"));
		addBk.sendcompany(p.getProperty("company"));
		addBk.sendAddress1(p.getProperty("Address1"));
		addBk.sendAddress2(p.getProperty("Address2"));
		addBk.sendCity(p.getProperty("city"));
		addBk.sendPostCode(p.getProperty("postcode"));
		addBk.selectCountry(p.getProperty("country"));
		addBk.selectZone(p.getProperty("zone"));
		addBk.clickcontinue();
		String smsg = addBk.AddressSuccessMsg();
		//SoftAssert
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(smsg, "Your address has been successfully added");
		sa.assertAll();
		}
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		logger.info("***** Ending TC007_AddressBookTest *****");
		
	}

}
