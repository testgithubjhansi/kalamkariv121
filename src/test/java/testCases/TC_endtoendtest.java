package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import pageObjects.HomePage;
import pageObjects.PasswordPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC_endtoendtest extends BaseClass {

	@Test

	public void endtoend() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.setusername(p.getProperty("email"));
		hp.clickSignin();
		PasswordPage pp = new PasswordPage(driver);
		pp.setpwd(p.getProperty("password"));
		pp.clickpwdsignin();
		Dashboard dp = new Dashboard(driver);
		dp.hoverOverimglogo();
		dp.clickpilock();
		dp.scrollAndClickTargetElement();
		ProductPage pdp = new ProductPage(driver);
		pdp.clickchbxcotton();
		pdp.clickchbxkalamkari();
		String titlrmsg=pdp.titlekalamkari();
		System.out.println(titlrmsg);
		Assert.assertEquals(titlrmsg, "# KNPS882 - Kalamkari New Print saree");
		pdp.clickbtnbcrs();
	
		
		

	}

}
