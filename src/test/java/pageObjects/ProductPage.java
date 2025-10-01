package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//label[@for='chk_MaterialTypes_Cotton']/preceding::p-checkbox")
	WebElement chbxcotton;

	@FindBy(xpath = "//span[text()='Kalamkari New Print saree']/preceding::p-checkbox[1]")
	WebElement chbxkalamkari;
	
	@FindBy(xpath = "//span[text()='# KNPS882 - Kalamkari New Print saree']")
	WebElement validatetitle;
	
	@FindBy(xpath = "//*[local-name()='svg' and @class='p-dialog-header-close-icon p-icon']")
	WebElement btnbcrs;

	public void clickchbxcotton() {
		chbxcotton.click();
	}

	public void clickchbxkalamkari() {
		chbxkalamkari.click();
	}

	public void clickbtnbcrs() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnbcrs));
		btnbcrs.click();
	}

	public String titlekalamkari() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(validatetitle));
		return validatetitle.getText();
	}

	

}
