package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            File reportFolder = new File("reports");

            if (!reportFolder.exists()) {
                reportFolder.mkdirs();
            }

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            "reports/AutomationReport.html"
                    );

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo(
                    "OS", System.getProperty("os.name")
            );

            extent.setSystemInfo(
                    "Java Version",
                    System.getProperty("java.version")
            );
        }

        return extent;
    }

}
