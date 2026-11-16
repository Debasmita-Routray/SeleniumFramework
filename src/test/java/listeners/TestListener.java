package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import driver.DriverManager;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.Log;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener{
	
	 @Override
	    public void onTestStart(ITestResult result) {

	        ExtentTest test = ExtentManager.getInstance()
	                .createTest(result.getName());

	        ExtentTestManager.setTest(test);

	        Log.info("TEST STARTED: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {

	        ExtentTestManager.getTest().pass("Test Passed");

	        Log.info("TEST PASSED: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	        Log.error("TEST FAILED: " + result.getName());

	        ExtentTestManager.getTest().fail(result.getThrowable());

	        String testName = result.getName();

	        ScreenshotUtils.takeScreenshot(
	                DriverManager.getDriver(),
	                testName
	        );

	        ExtentTestManager.getTest().addScreenCaptureFromPath(
	                "screenshots/" + testName + ".png"
	        );
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {

	        ExtentTestManager.getTest().skip("Test Skipped");

	        Log.warn("TEST SKIPPED: " + result.getName());
	    }

	    @Override
	    public void onFinish(
	            org.testng.ITestContext context) {

	        ExtentManager.getInstance().flush();

	        Log.info("Extent Report generated successfully");
	    }

}
