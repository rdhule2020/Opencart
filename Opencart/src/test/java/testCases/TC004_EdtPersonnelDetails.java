package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInformationPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC004_EdtPersonnelDetails extends BaseClass {

	@Test(groups = { "Sanity" })
	public void EditAccoutInformation() {
		logger.info("*****Starting TC004_EdtPersonnelDetails*****");
		try {
			HomePage h = new HomePage(driver);
			h.clickMyAccount();
			h.clickLogin();

			LoginPage l = new LoginPage(driver);
			l.setEmail(p.getProperty("email"));
			l.setPassword(p.getProperty("password"));
			l.clickLogin();

			MyAccountPage m = new MyAccountPage(driver);
			m.clickeditAccInfo();

			MyAccountInformationPage mip = new MyAccountInformationPage(driver);
			logger.info("***** Altering information *****");
			mip.clearfirstName();
			mip.setfirstName(p.getProperty("fname"));
			mip.getlname();
			mip.clearlastName();
			mip.setlname(p.getProperty("lname"));
			mip.getemail();
			mip.gettelephone();
			mip.clickContinue();

			m.clickeditAccInfo();
			mip.clickback();

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****Ending TC004_EdtPersonnelDetails*****");
	}

}
