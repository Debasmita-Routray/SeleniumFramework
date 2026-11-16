package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static void takeScreenshot(WebDriver driver, String fileName) {

		 TakesScreenshot ts = (TakesScreenshot) driver;

		    File source = ts.getScreenshotAs(OutputType.FILE);

		    File screenshotFolder = new File("screenshots");

		    if (!screenshotFolder.exists()) {
		        screenshotFolder.mkdirs();
		    }

		    File destination = new File(
		            screenshotFolder, fileName + ".png"
		    );

		    try {
		        Files.copy(source.toPath(), destination.toPath());
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}

}
