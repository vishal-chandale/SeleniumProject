package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	// comment 

	// pulled code and created new branch

	@BeforeTest
	public void BeforeTest() {


	}	

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws Exception {

		File file = new File("D:\\May 2022\\Workspace\\VillaSelect\\src\\test\\resources\\config.properties");

		FileInputStream fis= new FileInputStream(file);

		Properties prop= new Properties();
		prop.load(fis);
		String browser=prop.getProperty("browser");

		if(browser.equalsIgnoreCase("chrome")) {
			
			/*
			 * ChromeOptions options= new ChromeOptions();
			 * options.addArguments("disable-infobar"); options.setHeadless(true);
			 */				
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}		
		else if(browser.equalsIgnoreCase("firefox")) { 

			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}

		driver.navigate().to(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}

	//comment

	@AfterTest
	public void afterTest() throws InterruptedException {

	}

}
