package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement usertypefield;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertmessage;

	public AdminUserPage create() {
		newbutton.click();
		return this;
	}

	public AdminUserPage username(String user) {
		usernamefield.sendKeys(user);
		return this;
	}

	public AdminUserPage password(String pass) {
		passwordfield.sendKeys(pass);
		return this;
	}

	public AdminUserPage userType(String usertype) {
		usertypefield.sendKeys(usertype);
		return this;
	}

	public AdminUserPage submit() {
		savebutton.click();
		return this;
	}

	public boolean alert() {
		return alertmessage.isDisplayed();
	}
}
