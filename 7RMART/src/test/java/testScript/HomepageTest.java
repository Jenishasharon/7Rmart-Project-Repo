package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomepageTest extends Base {
	HomePage homepage;
	@Test(description = "Logout the homepage")
	public void checkWhetherTheUserIsAbleToLogoutTheApplication() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.signin();
		homepage.admin().logout();
		boolean isSignInDisplayed = homepage.isButtonVisible();
		Assert.assertTrue(isSignInDisplayed, Constants.HOMEPAGELOGOUT);

	}
}
