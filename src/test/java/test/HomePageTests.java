package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;

public class HomePageTests extends BaseTest{	
	
	
	@Test(priority=1)
	public void searchForVilla() {		
		
		HomePage homePage= new HomePage(driver);
		homePage.searchVilla();
		//test.log(Status.INFO,"Opened the Search resut page");
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("search?destination"));
		Assert.assertEquals(driver.getTitle(), "Search - Villa Select");
			
	}
	
	@Test
	public void test1() {
		
		
		//test.log(Status.INFO,"Dummy test case");
		//test.log(Status.INFO,"abc xyz");

		Assert.fail();
	}
	
	@Test
	public void test2() {
		
		
		//test.log(Status.INFO,"Dummy test case");
		//test.log(Status.INFO,"Dummy test case");
		
		throw new SkipException("This test should be skipped");
	}
	
	
}
