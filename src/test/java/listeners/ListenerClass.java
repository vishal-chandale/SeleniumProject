package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import test.BaseTest;
import utilities.ReportManager;

public class ListenerClass implements ITestListener {

	
	public static ExtentReports extent= ReportManager.initiateReport();
	public static ExtentTest test;
		
	public void onTestStart(ITestResult result) {

		test= extent.createTest(result.getTestClass().getName() +":-"+result.getMethod().getMethodName());
				
	}

	public void onTestSuccess(ITestResult result) {

		String methodName= result.getName().toString();
		test.pass("Test case is passed" + methodName);
		
	}

	public void onTestFailure(ITestResult result) {

		
		String methodName= result.getName().toString();
		String exception=result.getThrowable().getStackTrace().toString();
		
		
		File page= ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(page,new File(".//screenshot//screenshot4.png") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<img src=\"D:\\May 2022\\Workspace\\SeleniumDemo\\screenshot\\screenshot4.png\"/>");
	
		

		try {
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(".//screenshot//screenshot4.png").build());
		} 
		catch (IOException e) {
	
			e.printStackTrace();
		}
			
		test.log(Status.FAIL, exception);		
		test.fail("Test case is failed " + methodName);
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName= result.getName().toString();
		test.skip("Test case is Skipped " + methodName);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
		if(extent != null)
		extent.flush();		
	}

}
