package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {
	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement updatebutton;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonefield;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailfield;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressfield;
	@FindBy(xpath = "//textarea[@name='del_time']")
	private WebElement deliverytimefield;
	@FindBy(xpath = "//input[@name='del_limit']")
	private WebElement chargelimitfield;
	@FindBy(xpath = "//button[@type='submit' and @name='Update']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertmessage;

	public ManageContactPage updateContact() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver, updatebutton);
		updatebutton.click();
		return this;
	}

	public ManageContactPage enterPhoneNumber(String num) {
		phonefield.sendKeys(num);
		return this;
	}

	public ManageContactPage enterEmailText(String email) {
		emailfield.sendKeys(email);
		return this;
	}

	public ManageContactPage enterAddress(String adrs) {
		addressfield.sendKeys(adrs);
		return this;
	}

	public ManageContactPage enterDeliveryTime(String time) {
		deliverytimefield.sendKeys(time);
		return this;
	}

	public ManageContactPage enterChargeLimit(String charge) {
		chargelimitfield.sendKeys(charge);
		return this;
	}

	public ManageContactPage clickSubmitButton() {
		// savebutton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.jsExecuterClick(savebutton, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForAlertToBeVisible(driver);
		return alertmessage.isDisplayed();
	}
}
