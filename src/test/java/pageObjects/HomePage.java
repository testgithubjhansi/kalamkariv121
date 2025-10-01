package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='emailOrPhone']")
	WebElement txtemailID;
	
	@FindBy(xpath="//button[@id='signIn']")
	WebElement btnsingnin;
	
	@FindBy(xpath="//div[text()='We cannot find an account with the provided information.']")
	WebElement txterrmsg;
	@FindBy(xpath="//div[text()=' Please Enter Your Email ID or Mobile Number.']")
	WebElement txterrmsgwithoutinput;
	@FindBy(xpath="//div[@class='align-items-end text-left']")
	WebElement btnwithotsingnin;
	
	public void setusername(String fname) {
		txtemailID.sendKeys(fname);
	}
	public void clicktxtemailid() {
		txtemailID.click();
	}
	public void clickSignin()
	{
		btnsingnin.click();
		
	}
	
	public void clickwithoutinputSignin()
	{
		btnwithotsingnin.click();
		
	}
	
	public String getErrmsg() {
		try{
			return(txterrmsg.getText());
			}
		catch(Exception e) {
			
			return(e.getLocalizedMessage());
		
		}
	}
	
	public String getErrmsgwithoutinput() {
		try{
			return(txterrmsgwithoutinput.getText());
			}
		catch(Exception e) {
			
			return(e.getLocalizedMessage());
		
		}
	}
}
