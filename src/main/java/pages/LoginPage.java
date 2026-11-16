package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utils.Log;

public class LoginPage extends BasePage {
	
	

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
       super(driver);
        
    }
    
    // Enter username
    public void enterUsername(String username) {
    	Log.info("Entering username");
    	waitUtils.waitForVisibility(usernameField).sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        Log.info("Entering password");
    	waitUtils.waitForVisibility(passwordField).sendKeys(password);
    }

    // Click login button
    public void clickLogin() {
    	Log.info("Clicking login button");
    	waitUtils.waitForClickability(loginButton).click();
    }

    // Complete login operation
    public void login(String username, String password) {
    	Log.info("Starting login operation");
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public String getErrorMessage() {

        return waitUtils.waitForVisibility(errorMessage).getText();

    }

}
