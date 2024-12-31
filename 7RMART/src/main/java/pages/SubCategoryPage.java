package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtilities;
import utilities.PageUtility;

public class SubCategoryPage {
	WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	private WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subcat;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement file;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[1]")
	private WebElement deletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;

	public SubCategoryPage newCategory() {
		newbutton.click();
		return this;
	}

	public SubCategoryPage category() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(category, "Accessories");
		return this;
	}

	public SubCategoryPage subCategory(String subcategory) {
		subcat.sendKeys(subcategory);
		return this;
	}

	public SubCategoryPage image() throws AWTException {

		FileUploadUtilities fileuploadutilities = new FileUploadUtilities();
		// fileuploadutilities.fileuploadRobotClass(file,Constants.KIDSHAIRCLIPS);
		fileuploadutilities.fileuploadSendKeys(file, Constants.KIDSHAIRCLIPS);
		return this;
	}

	public SubCategoryPage clickSaveButton() {
		savebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

	public SubCategoryPage clickdDeleteButton() {
		deletebutton.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isAlertDelete() {
		return deleteAlert.isDisplayed();
	}
}
