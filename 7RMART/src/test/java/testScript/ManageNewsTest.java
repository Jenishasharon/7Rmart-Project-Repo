package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage managenewspage;
	HomePage homepage;

	@Test(description = "create news,retryAnalyzer = retry.Retry.class")
	public void verifyWhetherTheUserIsAbleToCreateNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String msg = ExcelUtility.getStringData(1, 0, "ManageNews");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.signin();
		managenewspage = homepage.manage();
		managenewspage.createNews().message(msg).saveMessage();
		Boolean isNewsCreated = managenewspage.alert();
		Assert.assertTrue(isNewsCreated, Constants.CREATENEWS);
	}
}
