package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends BasePage {
	
	public PasswordPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//input[@placeholder='Enter Password']")
	WebElement txtpasswrd;
	@FindBy(xpath="//span[text()='Sign In']")
	WebElement btnpwdsignin;


public void setpwd(String pswd) {
	txtpasswrd.sendKeys(pswd);
}

public void clickpwdsignin() {
	btnpwdsignin.click();
	
}
}