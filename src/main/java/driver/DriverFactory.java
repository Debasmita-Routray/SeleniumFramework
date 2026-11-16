package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import exceptions.FrameworkException;

public class DriverFactory {
	
	public static WebDriver createDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
            	throw new FrameworkException(
            	        "Unsupported browser: " + browser
            	    );
        }

        return driver;
    }

}
