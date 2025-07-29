package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC006_SearchTest extends BaseClass {

	@Test(groups = { "Master" })
	public void TC006_verifysearch() {
		logger.info("****Starting TC006_SearchTest****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// HomePage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// My Account Page
			MyAccountPage ma = new MyAccountPage(driver);
			logger.info("***** Sending value into search box *****");
			ma.send_search(p.getProperty("pname"));
			logger.info("***** Click on search button *****");
			ma.clicksearch();
			
//			String text = ma.getText_txtbox_search1();
//			Assert.assertEquals(text, p.getProperty("pname"));
			logger.info("***** Verification on search result page *****" );
			ma.clicksearch1();
			String txtmsg = ma.getresultmsg();
			Assert.assertEquals(txtmsg, "There is no product that matches the search criteria.");

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****Finished TC006_SearchTest****");
	}
}
