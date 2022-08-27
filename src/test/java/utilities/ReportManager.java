package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
	
		public static ExtentReports extent;	
	
	public static ExtentReports initiateReport() {
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./reports/extentreport.html");
		
		htmlReporter = new ExtentSparkReporter("./reports/extentreport.html");
		htmlReporter.config().setDocumentTitle("HTML Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Regression Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Org Name", "VillaSelect");
		extent.setSystemInfo("Testers Name", "Anshu Arora");

		return extent;
	}
	
}
