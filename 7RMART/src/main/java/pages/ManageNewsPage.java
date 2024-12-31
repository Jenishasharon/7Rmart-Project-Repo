package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement create;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement information;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManageNewsPage createNews() {
		create.click();
		return this;
	}

	public ManageNewsPage enterMessage(String newmessage) {
		information.sendKeys(newmessage);
		return this;
	}

	public ManageNewsPage saveMessage() {
		save.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
