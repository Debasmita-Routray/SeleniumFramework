package base;

import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import utils.SeleniumUtils;
import utils.WaitUtils;

public class BasePage {
	
	protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected SeleniumUtils seleniumUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int timeout = Integer.parseInt(
                ConfigReader.getProperty("timeout")
        );

        this.waitUtils = new WaitUtils(driver, timeout);
        this.seleniumUtils = new SeleniumUtils(driver);
    }

}
