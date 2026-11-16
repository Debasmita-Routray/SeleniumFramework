package base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import utils.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	@BeforeSuite
	public void loadConfig() {
	    ConfigReader.loadProperties();
	}
	
	/*@BeforeSuite tells TestNG to execute this method once before the test suite starts.
      ConfigReader.loadProperties() loads the values from config.properties.
      After that, our test methods can access those values through ConfigReader.getProperty()*/
	
	@BeforeMethod
	public void setUp() {
		
		 // Get browser from Maven command or use Chrome by default
    	  String browser = System.getProperty(
    		        "browser",
    		        ConfigReader.getProperty("browser")
    		);
    	Log.info("Starting browser: " + browser);	  
         // Create browser using DriverFactory
        WebDriver driver = DriverFactory.createDriver(browser);
        Log.info("Browser launched successfully");
        DriverManager.setDriver(driver);
		getDriver().manage().window().maximize();
		Log.info("Browser window maximized");
		getDriver().get(ConfigReader.getApplicationUrl());
		Log.info("Application opened successfully");
		
		
	}
	
	 protected WebDriver getDriver() {
	        return DriverManager.getDriver();
	    }

	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		 WebDriver driver = DriverManager.getDriver();

	        try {
	            if (driver != null) {
	            	Log.info("Closing browser");
	                driver.quit();
	            }
	        } finally {
	            DriverManager.unload();
	        }
		
	}

}
