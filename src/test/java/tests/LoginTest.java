package tests;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.TestListener;

import base.BaseTest;
import config.ConfigReader;
import exceptions.FrameworkException;
import pages.LoginPage;
import utils.WaitUtils;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	
	
	 
	 @Test
	 public void verifySuccessfulLogin() {

	        // Create LoginPage object
	        LoginPage loginPage = new LoginPage(getDriver());
	        int timeout = Integer.parseInt(
	                ConfigReader.getProperty("timeout")
	        );
	        WaitUtils waitUtils = new WaitUtils(getDriver(),timeout);

	        // Perform login
	        loginPage.login("standard_user", "secret_sauce");

	        // Verify successful login
	        String actualUrl = getDriver().getCurrentUrl();

	       Assert.assertTrue(waitUtils.waitForUrlContains(actualUrl),"Login was unsuccessful!");
	       
	      
	    }
	 
	
}
