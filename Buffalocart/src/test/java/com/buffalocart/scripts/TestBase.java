package com.buffalocart.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.buffalocart.constants.AutomationConstants;

public class TestBase {
	public static WebDriver driver;
	public static Properties property;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUpBrowser(String browser) throws IOException {
		
		property = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources" + "/config.properties");
		property.load(ip);
		if (browser.equalsIgnoreCase("Chrome")) {
			String driverPath = property.getProperty("ChromeDriverPath");
			System.setProperty(AutomationConstants.CHROMEDRIVER, driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			String driverPath = property.getProperty("FirefoxDriverPath");
			System.setProperty(AutomationConstants.FIREFOXDRIVER, driverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		
		}else {
			System.out.println("No valid browser driver available");
		}
		
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	}
		
}
	
	
	
	
	
	
	/*public static WebDriver driver;
	public static Properties prop =null;

	public static void TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources" + "/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	@Parameters("browser")

	public void setup(String browser1) {
		TestBase();

		if (browser1.equalsIgnoreCase("Chrome")) {
			String driverPath = prop.getProperty("ChromeDriverPath");
			System.setProperty(AutomationConstants.CHROMEDRIVER, driverPath);
			driver = new ChromeDriver();
		} else if (browser1.equalsIgnoreCase("firefox")) {
			String driverPath = prop.getProperty("FirefoxDriverPath");
			System.setProperty(AutomationConstants.FIREFOXDRIVER, driverPath);
			driver = new FirefoxDriver();
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

	}}*/
	//Taking screenshot
	/*@AfterMethod
	public void tearDown(ITestResult iTestResult) throws IOException {
	    if (iTestResult.getStatus()==iTestResult.FAILURE) {
	        takeScreenshot(iTestResult.getName());
	    }
	    
	}

	public String takeScreenshot(String name) throws IOException {
		
		
		/*Step 1) Convert web driver object to TakesScreenshot
	Step 2) Call getScreenshotAs method to create image file
	Step 3) Copy file to Desired Location*/
		/*String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    //Take the screenshot
	File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      
	      String destination =  System.getProperty("user.dir") + "\\target\\" + name + dateName
	              + ".png";
	     
	      File finalDestination = new File(destination);
	   
	    FileHandler.copy(source,finalDestination);
	      //FileHandler.copy(source, finalDestination); //or  FileHandler.copy FileUtils.copyFile
	     return destination;
	}}*/


