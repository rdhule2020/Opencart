package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC005_CheckoutTest extends BaseClass {


		
		@Test(groups= {"Master"})
		
		public void Verify_checkoutonHomePage()
		{
			logger.info("*****Starting TC005_CheckoutTests*****");
			try {
			HomePage h=new HomePage(driver);
			h.clickcheckout();
			
			CheckoutPage ch = new CheckoutPage(driver);
			String cartmsg = ch.getCartMsg();
			if(cartmsg.equals("Your shopping cart is empty!"))
			{
				ch.clickcontinue();
			}
			logger.info("***** Adding product to cart ****");
			h.clickmac_Addtocart();
			h.getsuccescartmsg();
		
	//Assert.assertEquals(successmsg, "Success: You have added MacBook to your shopping cart!");
			logger.info("*****Clicking on Shopping cart*****");
			h.clickshoppingcart();
			logger.info("***** Clicking on remove product *****");
			h.clickremove();
			
			
		}catch(Exception e) {
			Assert.fail();
		}
			logger.info("*****Ending TC005_CheckoutTests*****");
	}
}
