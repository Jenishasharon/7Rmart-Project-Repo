package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(description = "Login with correct username and password", retryAnalyzer = retry.Retry.class, groups = {
			"Regression" })
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signIn();
		boolean ishomepageavilable = loginpage.isHomePageLoaded();
		Assert.assertTrue(ishomepageavilable, Constants.LOGINWITHVALIDCREDENTIALS);

	}

	@Test(description = "Login with correct username and incorrect password", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsNotAbleToLoginWithCorrectUsernameAndIncorrectPassword() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getIntegerData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signIn();
		boolean alertCheck = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertCheck, Constants.LOGINWITHINVALIDUSERNAME);

	}

	@Test(description = "Login with incorrect username and correct password", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsNotAbleToLoginWithIncorrectUsernameAndCorrectPassword() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signIn();
		boolean alertCheck = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertCheck, Constants.LOGINWITHINVALIDPASSWORD);
	}

	@Test(dataProvider = "LoginProvider")
	public void validateTheUserIsNotAbleToLoginUsingInvalidCredentials(String usernamevalue, String passwordvalue)
			throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signIn();
		boolean alertCheck = loginpage.isAlertDisplayed();
		Assert.assertTrue(alertCheck, Constants.LOGINWITHINVALIDCREDENTIALS);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getStringData(4, 0, "LoginPage"), ExcelUtility.getStringData(4, 1, "LoginPage") } };
	}
}
