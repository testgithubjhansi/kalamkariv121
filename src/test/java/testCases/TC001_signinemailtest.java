package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_signinemailtest extends BaseClass {

	@Test
	public void verify_email_registration() {
		// logger.info("started");
		HomePage hp = new HomePage(driver);
		hp.setusername(p.getProperty("email"));
		hp.clickSignin();

	}

	@Test
	public void verify_errmsg_withimpropermail() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		driver.navigate().refresh();
		hp.setusername("hjghj");
		hp.clickSignin();
		Thread.sleep(5000);
		String experr = hp.getErrmsg();
		Assert.assertEquals(experr, "We cannot find an account with the provided information.");

	}

	@Test()
	public void verify_errmsg_withoutmail() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		driver.navigate().refresh();
		hp.clicktxtemailid();
		Thread.sleep(5000);
		hp.clickwithoutinputSignin();
		String experrwithoutin = hp.getErrmsgwithoutinput();
		Assert.assertEquals(experrwithoutin, "Please Enter Your Email ID or Mobile Number.");
	}
}