package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddressBookPage;
import pageObjects.EditAddressPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC008_EditAddressBook extends BaseClass {
	@Test
	public void EditAddressBook() {
		logger.info("***** Started Executing TC00*_EditAddressBookTest *****");
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

			AddressBookPage addBk = new AddressBookPage(driver);
			addBk.clickEdit();

			EditAddressPage ep = new EditAddressPage(driver);
			ep.clearFirstName();
			addBk.sendfirstName(p.getProperty("fname1"));
			ep.clearlastName();
			addBk.sendlastName(p.getProperty("lname1"));
			ep.clearCompany();
			addBk.sendcompany(p.getProperty("company1"));
			ep.clearCity();
			addBk.sendCity(p.getProperty("city1"));
			ep.clearAddress1();
			addBk.sendAddress1(p.getProperty("Address1"));
			ep.clearAddress2();
			addBk.sendAddress2(p.getProperty("Address2"));
			ep.clearpostcode();
			addBk.sendPostCode(p.getProperty("postcode"));
			ep.clickContinue();
			String m = ep.getmsg();
			Assert.assertEquals(m, "Your address has been successfully updated");
		} catch (Exception e) {
			e.getMessage();
			Assert.fail();
		}
		logger.info("***** Ending TC00*_EditAddressBookTest *****");
	}
}
