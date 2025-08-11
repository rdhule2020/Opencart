package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MP3PlayerPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC009_MP3PlayerAddToCartTest extends BaseClass{

	@Test
	public void verify_MP3PlayerAddToCartFeature() {
		
		logger.info("**** Started execting TC009_MP3PlayerAddToCartTest **** ");
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("**** Using login data from config1.properties ****");
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p1.getProperty("email"));
		lp.setPassword(p1.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage ap = new MyAccountPage(driver);
		hp.clickMyAccount();
		ap.clickOptionMyAccount();
		ap.clickheader_MP3();
		ap.clickbtn_showAllMp3Player();
		
		logger.info("**** navigating to MP3 page ****");
		//MP3 Player page
		MP3PlayerPage mp3 = new MP3PlayerPage(driver);
		//mp3.sortBy(p.getProperty("sortBy"));
		mp3.show(p1.getProperty("show"));
		String nano = mp3.gettitleNano();
		String classic = mp3.gettitleClassic();
		String touch = mp3.gettitleTouch();
		String shuffle = mp3.gettitleshuffle();
		
		
		logger.info("**** Selecting produt ****");
		if(nano.equalsIgnoreCase("ipod Nano"))
		{
			mp3.clickipodnano();
		}else if(classic.equalsIgnoreCase("ipod Classic"))
		{
			mp3.clickipodclassic();
		}else if(touch.equalsIgnoreCase("ipod Touch"))
		{
			mp3.clickipodtouch();
		}else
		{
			mp3.clickipodshuffle();
		}
		
		
		}catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		
		logger.info("**** TC009_MP3PlayerAddToCartTest executed successfully ****");
	}
}
