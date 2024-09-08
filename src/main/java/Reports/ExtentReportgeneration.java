package Reports;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportgeneration implements ITestListener
{
	  ExtentSparkReporter sparkReporter;   //UI of Report  (Look & Feel)
      ExtentReports extent;	//populate info to the report  eq:- ProjectName, ModuleName, tester name, browser name, OS
      ExtentTest test;         //creating test case entries in reports & update status of test method
	
	
	  	public void onStart(ITestContext context) 
	    {
	  		//will execute before execution of all test methods in class/test (only once)
	  		
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");  
		    String date1 = dateFormat.format(new Date());  
	  		
	  	    sparkReporter = new ExtentSparkReporter("src/main/java/Reports_"+date1+".html");
	        sparkReporter.config().setDocumentTitle("3rd Rest Assured Automation Framework Report");  //title of the report
	        sparkReporter.config().setReportName("Test Report");
	        sparkReporter.config().setTheme(Theme.STANDARD);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        
	        extent.setSystemInfo("Envirnment", "QA");
	        extent.setSystemInfo("Browser Name", "Chrome");  
	        extent.setSystemInfo("Tester Name", "Amruta");
	    }

	    public void onTestSuccess(ITestResult result)
	    {
	       //execute after test method is pass
	    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
	        test.log(Status.PASS, "Test case is Passed: "+result.getName());    //update status
	    }

	    public void onTestFailure(ITestResult result) 
	    {
	        //execute after test method is fail
	    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
	        test.log(Status.FAIL, "Test case is Failed: "+result.getName());    //update status
	        test.log(Status.FAIL, "Test case is Failed cause: "+result.getThrowable());  //get failure msg
	    }

	    public void onTestSkipped(ITestResult result) 
	    {
	      //execute after test method is skip
	    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
	        test.log(Status.SKIP, "Test case is Skipped: "+result.getName()); 
	    }

	    public void onFinish(ITestContext context) 
	    {
	         //execute after all test method execution is finish
	    	  if (extent != null) 
	    	  {
	              extent.flush();
	          }
	    }
}
