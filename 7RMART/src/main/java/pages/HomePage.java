package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logoutbutton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement moreinfobutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class=\" nav-link\"]")
	private WebElement managemoreinfobutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement footermoreinfobutton;
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='nav-link']")
	private WebElement productmoreinfobutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subcatmoreinfo;

	public AdminUserPage adminMoreInfo() {
		PageUtility pageutility = new PageUtility();
		pageutility.jsExecuterClick(moreinfobutton, driver);
		return new AdminUserPage(driver);
	}

	public ManageContactPage contactMoreInfo() {
		PageUtility pageutility = new PageUtility();
		pageutility.jsExecuterClick(managemoreinfobutton, driver);
		return new ManageContactPage(driver);
	}

	public ManageFooterTextPage footerMoreInfo() {
		PageUtility pageutility = new PageUtility();
		pageutility.jsExecuterClick(footermoreinfobutton, driver);
		return new ManageFooterTextPage(driver);
	}

	public ManageNewsPage manage() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

	public ManageProductPage productMoreInfo() {
		PageUtility pageutility = new PageUtility();
		pageutility.jsExecuterClick(productmoreinfobutton, driver);
		return new ManageProductPage(driver);
	}

	public SubCategoryPage subCategoryMoreInfo() {
		subcatmoreinfo.click();
		return new SubCategoryPage(driver);
	}

	public HomePage admin() {
		admin.click();
		return this;
	}

	public LoginPage logout() {
		logoutbutton.click();
		return new LoginPage(driver);
	}

	public boolean isButtonVisible() {
		return signin.isDisplayed();
	}
}
