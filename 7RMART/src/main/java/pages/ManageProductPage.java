package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement titlefield;
	@FindBy(xpath = "//input[@value='Others']")
	private WebElement typeradiobutton;
	@FindBy(xpath = "//input[@id='m_weight']")
	private WebElement weightfield;
	@FindBy(xpath = "//input[@id='w_price']")
	private WebElement pricefield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;

	public ManageProductPage create() {
		newbutton.click();
		return this;
	}

	public ManageProductPage productTitle(String title) {
		titlefield.sendKeys(title);
		return this;
	}

	public ManageProductPage radio() {
		typeradiobutton.click();
		return this;
	}

	public ManageProductPage weight(String weightvalue) {
		weightfield.sendKeys(weightvalue);
		return this;
	}

	public ManageProductPage price(String pricevalue) {
		pricefield.sendKeys(pricevalue);
		return this;
	}

	public void submit() {
		PageUtility pageutility = new PageUtility();
		pageutility.jsExecuterClick(savebutton, driver);
		// savebutton.click();
	}

	public String getAlertText() {
		return PageUtility.getTextFromAlert(driver);
	}
}