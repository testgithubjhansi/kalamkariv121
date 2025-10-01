package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import pageObjects.HomePage;
import pageObjects.PasswordPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_signinpwdtest extends BaseClass {
	

    @Test(dataProvider="loginData",dataProviderClass=DataProviders.class)
 public void signinpage(String email, String pwd,String exp) throws InterruptedException
{
	HomePage hp = new HomePage(driver);
	hp.setusername(email);
	hp.clickSignin();
	PasswordPage pp = new PasswordPage(driver);
	pp.setpwd(pwd);
	pp.clickpwdsignin();
	Dashboard dp = new Dashboard(driver);
	boolean targetpage = dp.isMYDasboardExists();
	Assert.assertTrue(targetpage, null);
	String title= dp.printtitle();
	System.out.println(title);
	Thread.sleep(5000);
	dp.clickslkwadmin();
	dp.clicklogout();
	
}


	
    @Test(dataProvider="loginData",dataProviderClass=DataProviders.class)
public void imglogotest(String email, String pwd,String exp)
{
	HomePage hp = new HomePage(driver);
	driver.navigate().refresh();
	hp.setusername(email);
	hp.clickSignin();
	PasswordPage pp = new PasswordPage(driver);
	pp.setpwd(pwd);
	pp.clickpwdsignin();
	Dashboard dp = new Dashboard(driver);
	boolean flag=dp.validateimglogo();
	Assert.assertTrue(flag);
}

}
