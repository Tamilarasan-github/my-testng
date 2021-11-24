package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Reporter
{

	private static Logger log=LogManager.getLogger(Reporter.class.getName());
	
	public static ExtentReports extentReport;
	public ExtentTest extentTest;

	public static void startExtentReport()
	{
		extentReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/Spark.html");
		extentReport.attachReporter(spark);
		log.debug("startExtentReport() is triggered and extent report is started");
	}

	public void createNewTest(String desc, String testName)
	{
		extentTest = extentReport.createTest(desc, testName);
		log.debug("createNewTest(String desc, String testName) is triggered and new test is created with desc as "+desc+" and testName as "+testName);
	}

	public void log(Status status, String details)
	{
		if(status.equals(Status.FAIL))
		{
			extentTest.log(status, details, MediaEntityBuilder
					.createScreenCaptureFromPath(takeScreenshot()).build());
			log.debug("log(Status status, String details) is triggered and status is "+status+" and details are "+details);
		}
		else
		{
			extentTest.log(status, details);
		}
	}

	public void log(Status status, String details, boolean takeScreenshot)
	{
		if (takeScreenshot)
		{
			extentTest.log(status, details, MediaEntityBuilder
					.createScreenCaptureFromPath(takeScreenshot()).build());
			log.debug("log(Status status, String details, boolean takeScreenshot) is triggered and status is "+status+", details are "+details+" and takeScreenshot is "+takeScreenshot);
		} 
		else
		{
			extentTest.log(status, details);
		}
	}


	public static void saveReport()
	{
		extentReport.flush();
		log.debug("saveReport() is triggered and report is flushed/saved");

	}
	
	
	
	public abstract String takeScreenshot();
	
}
