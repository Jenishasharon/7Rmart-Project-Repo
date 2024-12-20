package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	ManageContactPage managecontactpage;
	HomePage homepage;

	@Test(description = "updating the contact details", retryAnalyzer = retry.Retry.class)
	public void checkWhetherTheUserIsAbleToUpdateContactDetails() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.signin();
		String phonenumber = ExcelUtility.getIntegerData(1, 0, "ManageContact");
		String emailvalue = ExcelUtility.getStringData(1, 1, "ManageContact");
		String addressvalue = ExcelUtility.getStringData(1, 2, "ManageContact");
		String delivtime = ExcelUtility.getIntegerData(1, 3, "ManageContact");
		String delivcharge = ExcelUtility.getIntegerData(1, 4, "ManageContact");
		managecontactpage = homepage.contactMoreInfo();
		managecontactpage.update().phone(phonenumber).emailText(emailvalue).address(addressvalue)
				.deliveryTime(delivtime).chargeLimit(delivcharge).submit();
		boolean isAlertDisplayed = managecontactpage.alert();
		Assert.assertTrue(isAlertDisplayed, Constants.UPDATECONTACT);
	}
}
