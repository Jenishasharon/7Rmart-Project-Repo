package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	AdminUserPage adminuserpage;
	HomePage homepage;

	@Test(description = "creating new user", retryAnalyzer = retry.Retry.class)
	public void verifyWhetherTheAdminIsAbleToCreateNewUser() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		String username = ExcelUtility.getStringData(1, 0, "AdminUser");
		String password = ExcelUtility.getStringData(1, 1, "AdminUser");
		String usertype = ExcelUtility.getStringData(1, 2, "AdminUser");
		adminuserpage = homepage.adminMoreInfo1();
		adminuserpage.createNewUser().enterUserName(username).enterPassword(password).enterUserType(usertype).clickSubmitButton();
		Boolean isAlertDisplayed = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.CREATENEWUSER);

	}
}
