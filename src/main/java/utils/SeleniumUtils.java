package utils;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtils {
	
	private WebDriver driver;
    private Actions actions;

    public SeleniumUtils(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }
    
    public void selectByVisibleText(WebElement element, String text) {

        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value) {

        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByIndex(WebElement element, int index) {

        Select select = new Select(element);
        select.selectByIndex(index);
    }
    
    public void mouseHover(WebElement element) {

        actions.moveToElement(element).perform();
    }

    public void rightClick(WebElement element) {

        actions.contextClick(element).perform();
    }

    public void doubleClick(WebElement element) {

        actions.doubleClick(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {

        actions.dragAndDrop(source, target).perform();
    }
    
    public void clickUsingJS(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);
    }

    public void sendKeysUsingJS(WebElement element, String text) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value=arguments[1];", element, text);
    }

    public void scrollToElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void acceptAlert() {

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText() {

        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void sendKeysToAlert(String text) {

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
    
    public void switchToFrame(int index) {

        driver.switchTo().frame(index);
    }
    
    public void switchToFrame(String nameOrId) {

        driver.switchTo().frame(nameOrId);
    }
    
    public void switchToFrame(WebElement frameElement) {

        driver.switchTo().frame(frameElement);
    }
    
    public void switchToDefaultContent() {

        driver.switchTo().defaultContent();
    }
    
    public void switchToParentFrame() {

        driver.switchTo().parentFrame();
    }
    
    public void switchToWindow(String windowHandle) {

        driver.switchTo().window(windowHandle);
    }
    
    public Set<String> getWindowHandles() {

        return driver.getWindowHandles();
    }
    
    public void scrollToBottom() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    public void scrollToTop() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, 0);");
    }

}
