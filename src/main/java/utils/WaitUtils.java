package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private WebDriverWait wait;
	
	public WaitUtils(WebDriver driver, int timeoutSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }
    
    public WebElement waitForClickability(By locator) {
    	
    	return wait.until
    			(ExpectedConditions.elementToBeClickable(locator)
    	);
    }
    
    public WebElement waitForPresence(By locator) {
    	return wait.until(ExpectedConditions.presenceOfElementLocated(locator)
    	);
    }
    
    public boolean waitForInvisibility(By locator) {
    	return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)
    			
    			
    	);
    }
    
    public boolean waitForUrlContains(String url) {
        return wait.until(
            ExpectedConditions.urlContains(url)
        );
    }

}
