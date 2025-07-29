package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC006_CheckoutTest extends BaseClass {


		
		@Test
		
		public void Verify_checkoutonHomePage()
		{
			
			try {
			HomePage h=new HomePage(driver);
			h.clickcheckout();
			
			CheckoutPage ch = new CheckoutPage(driver);
			String cartmsg = ch.getCartMsg();
			if(cartmsg.equals("Your shopping cart is empty!"))
			{
				ch.clickcontinue();
			}
			
			h.clickmac_Addtocart();
			if(h.getsuccescartmsg().equals(" Success: You have added MacBook to your shopping cart!"))
			{
				h.clickshoppingcart();
			}
			
		}catch(Exception e) {
			Assert.fail();
		}
	}
}
