package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;



public class Helper extends SuperHelper{

	public String description;
	public String testcaseName;
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("@BeforeSuite");
		loadProperties();
		startExtentReport();
		
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("@BeforeTest");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("@BeforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("@BeforeMethod");
		createNewTest(description, testcaseName);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("@AfterSuite");
		
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("@AfterTest");
		saveReport();
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("@AfterClass");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("@AfterMethod");
		
	}
	
	@DataProvider
	public void myDataProvider()
	{
		
	}
}
