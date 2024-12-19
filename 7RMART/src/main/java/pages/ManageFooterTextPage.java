package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement update;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressfield;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailfield;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement phonenumber;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertmessage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	private WebElement actionbutton;

	public ManageFooterTextPage updateInfo() {
		update.click();
		return this;
	}

	public ManageFooterTextPage address(String adrs) {
		addressfield.sendKeys(adrs);
		return this;
	}

	public ManageFooterTextPage email(String emailadrs) {
		emailfield.sendKeys(emailadrs);
		return this;
	}

	public ManageFooterTextPage phone(CharSequence phonenum) {
		phonenumber.sendKeys(phonenum);
		return this;
	}

	public ManageFooterTextPage update() {
		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertmessage.isDisplayed();
	}

	public ManageFooterTextPage updateVisible() {
		if (update.isDisplayed()) {
			System.out.println("Update button is visible");
		} else {
			System.out.println("Update button is not visible");
		}
		return this;
	}
}
