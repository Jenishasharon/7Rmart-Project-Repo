package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	HomePage homepage;
	SubCategoryPage subcategorypage;

	@Test(description = "create new category", retryAnalyzer = retry.Retry.class)
	public void checkWhetherTheUserIsAbleToCreateNewCategory() throws IOException, AWTException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String subcategoryvalue = ExcelUtility.getStringData(1, 0, "SubCategory");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		subcategorypage = homepage.subCategoryMoreInfo();
		subcategorypage.newCategory().category().subCategory(subcategoryvalue).image().save();
		boolean alertCheck = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(alertCheck, Constants.CREATECATEGORY);
	}

	@Test(description = "Delete a category")
	public void checkWhetherTheUserIsAbleToDeleteSubCategory() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		subcategorypage = homepage.subCategoryMoreInfo();
		subcategorypage.delete();
		boolean alertCheck = subcategorypage.isAlertDelete();
		Assert.assertTrue(alertCheck, Constants.DELETECATEGORY);
	}
}
