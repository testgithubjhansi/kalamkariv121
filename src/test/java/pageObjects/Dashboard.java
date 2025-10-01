package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard extends BasePage {

	public Dashboard(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div/h4[text()='Sree Lakshmi Kalamkari Works ']")
	WebElement Dashbtitle;

	@FindBy(xpath = "//a[@class='app-logo cursor-pointer']")
	WebElement imglogo;

	@FindBy(xpath = "//span[@class='text-white ml-2 text-xs font-italic']")
	WebElement imgslkwadmin;

	@FindBy(xpath = "//ul[@class='active-topbar-menu mt-2 p-4 topbar-menu w-15rem z-5']//li[5]")
	WebElement btnlogout;

	@FindBy(xpath = "//i[@class='pi pi-lock']")
	WebElement btnpilock;

	@FindBy(xpath = "//span[@class='layout-menuitem-text ng-tns-c2000835034-15']")
	WebElement txtproduct;

	public boolean isMYDasboardExists() {
		try {
			return (Dashbtitle.isDisplayed());

		} catch (Exception e) {
			return false;
		}
	}

	public String printtitle() {
		return Dashbtitle.getText();
	}

	public boolean validateimglogo() {
		return imglogo.isDisplayed();

	}

	public void clickslkwadmin() {
		imgslkwadmin.click();
	}

	public void clicklogout() {
		btnlogout.click();

	}

	public void clickpilock() {
		btnpilock.click();

	}

	public void hoverOverimglogo() {
		Actions actions = new Actions(driver);
		actions.moveToElement(imglogo).perform();
	}

	public void scrollAndClickTargetElement() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", txtproduct);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(txtproduct));

		txtproduct.click();
	}

}
