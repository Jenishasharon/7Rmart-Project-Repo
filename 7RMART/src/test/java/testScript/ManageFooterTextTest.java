package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	ManageFooterTextPage managefootertextpage;
	HomePage homepage;

	@Test(description = "updating the footer text data")
	public void checkWhetherTheuserIsAbleToUpdateFooterText() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.signin();
		String addressvalue = ExcelUtility.getStringData(1, 0, "FooterText");
		String emailvalue = ExcelUtility.getStringData(1, 1, "FooterText");
		String phonenum = ExcelUtility.getIntegerData(1, 2, "FooterText");
		managefootertextpage = homepage.footerMoreInfo();
		managefootertextpage.updateInfo().address(addressvalue).email(emailvalue).phone(phonenum).update();
		boolean alertCheck = managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(alertCheck, Constants.UPDATEFOOTERTEXT);
	}

	@Test(description = "veiwing the update button is present or not")
	public void verifyWhethertheUserIsAbleToViewUpdateButtonIsPresent() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.signin();
		managefootertextpage = homepage.footerMoreInfo();
		managefootertextpage.updateVisible();
		boolean isActionButtonPresent = managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(isActionButtonPresent, Constants.UPDATEVISIBLE);
	}
}
