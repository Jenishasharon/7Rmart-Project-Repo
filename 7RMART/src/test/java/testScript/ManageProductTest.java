package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
	ManageProductPage manageproductpage;
	HomePage homepage;

	@Test(description = "get allert message when mandatory field is left empty while creating new product")
	public void checkWhetherTheUserIsAbleToGetAlertMessageWhenMandatoryFieldIsLeftEmptyWhileCreatingNewProduct()
			throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		String titlevalue = ExcelUtility.getStringData(1, 0, "ManageProduct");
		String weightvalue = ExcelUtility.getIntegerData(1, 1, "ManageProduct");
		String pricevalue = ExcelUtility.getIntegerData(1, 2, "ManageProduct");
		String expectedalerttext =ExcelUtility.getStringData(1,3, "ManageProduct"); ;
		manageproductpage = homepage.productMoreInfo();
		manageproductpage.createNewProduct().productTitle(titlevalue).productType().productPrice(pricevalue).productWeight(weightvalue).clickSubmitButton();
		String actualalerttext = manageproductpage.isGetAlertText();
		Assert.assertEquals(actualalerttext, expectedalerttext, Constants.CREATEPRODUCT);
	}
}