package com.basetest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.utils.Driverpaths;
import com.utils.ScreenshotUtility;



public class Baseclass {
	 private static String tcName;
	public static WebDriver driver;
	public static Properties p;
	
	@Parameters({"browser"})
	@BeforeSuite
	public  void OpenBrowser(@Optional("chrome")String browser) {
		
		 p= new Properties();//this method is using for read data from config.properties
		FileReader fr;
		try {
			fr = new FileReader("C:\\Users\\91988\\eclipse-workspace\\newprojecct\\src\\ConfigFiles\\config.properties");
			p.load(fr);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
          
		
	//	WebDriverManager.edgedriver().setup();
		String curDir = System.getProperty("user.dir");
		
		if(browser.equalsIgnoreCase("edge")) {
//String curDir=System.getProperty("user.dir");
//System.out.println(curDir);
			WebDriverManager.iedriver().setup();
			System.setProperty(Driverpaths.ieKey,Driverpaths.ievalue);
			driver=new EdgeDriver();
			init();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty(Driverpaths.chromeKey,Driverpaths.chromevalue);
			driver=new ChromeDriver();
			init();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(Driverpaths.firefoxkey,com.utils.Driverpaths.firefoxvalue);
			driver=new FirefoxDriver();
			init();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty(com.utils.Driverpaths.ieKey,com.utils.Driverpaths.ievalue);
			driver=new InternetExplorerDriver();
			init();
		}
	}
		@BeforeMethod
		public void beforeTCExecution(Method method) {
			String tcName = method.getName();
			System.out.println("Currently executing test case is: "+tcName);
		}
		@AfterMethod
		public void afterTCExecution(ITestResult result) throws WebDriverException, IOException {
			String tcName=result.getMethod().getMethodName();
			if(result.getStatus()==ITestResult.SUCCESS) {
		System.out.println("TC is Passed: "+tcName);	
		}
			else if(result.getStatus()==ITestResult.FAILURE) {
				System.out.println("TC is Failed: "+tcName);
				ScreenshotUtility.ScreenShotUtility.takeScreenshot(tcName);
				
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				System.out.println("TC is Skipped: "+tcName);
				ScreenshotUtility.ScreenShotUtility.takeScreenshot(tcName);
			}
		
	
	}

	
		
	private void init() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
		
	}
	

	//public static WebDriver getDriver(){ 
		
//}

	@AfterSuite
    public void closeBrowser() {
  	  if(driver!=null) {
  		  driver.close();
  	  }
  	  else {
  		  System.out.println("driver not found");
	}
	}
	public static String getTcName() {
		return tcName; 
	
	}
	
}
