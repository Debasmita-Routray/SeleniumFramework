package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.TestListener;
import base.BaseTest;
import config.ConfigReader;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.WaitUtils;

@Listeners(TestListener.class)
public class LoginDataTest extends BaseTest {
	
	 @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password,boolean expectedResult,String expectedErrorMessage) {

		 LoginPage loginPage = new LoginPage(getDriver());
		 int timeout = Integer.parseInt(
			        ConfigReader.getProperty("timeout")
			);

	     WaitUtils waitUtils = new WaitUtils(getDriver(), timeout);
         loginPage.login(username, password);
         if (expectedResult) {

             Assert.assertTrue(
                     waitUtils.waitForUrlContains("inventory.html"),
                     "Login should be successful for: " + username
             );

         } else {

             String actualErrorMessage = loginPage.getErrorMessage();

             Assert.assertEquals(
                     actualErrorMessage,
                     expectedErrorMessage,
                     "Error message validation failed for: " + username
             );

	    }
	 }
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {

		String filePath = "src/test/resources/testdata/LoginData.xlsx";

	    int rowCount = ExcelUtils.getRowCount(filePath, "LoginData");

	    Object[][] data = new Object[rowCount][4];

	    for (int i = 1; i <= rowCount; i++) {

	        data[i - 1][0] = ExcelUtils.getCellData(filePath, "LoginData", i, 0);

	        data[i - 1][1] = ExcelUtils.getCellData(filePath, "LoginData", i, 1);

	        data[i - 1][2] = Boolean.parseBoolean(
	                ExcelUtils.getCellData(filePath, "LoginData", i, 2)
	        );

	        data[i - 1][3] = ExcelUtils.getCellData(filePath, "LoginData", i, 3);
	    }

	    return data;
	}
}
