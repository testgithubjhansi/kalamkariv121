package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	static ExtentTest test;
	String repName;
	
	public void onStart(ITestContext testcontext) {
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report" + timestamp+".html";
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\ereport.html");
		sparkReporter.config().setDocumentTitle("slmk");
		sparkReporter.config().setReportName("slmk testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("App", "slmk");
		
		String os =testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("os", os);
		
		String browser =testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);
		
		List<String> includeGroups =testcontext.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty()) {
			extent.setSystemInfo("groups", includeGroups.toString());
		}
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test =extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"got success executed");
		
	}
public void onTestFailure(ITestResult result) {
		
		test =extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+"got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		try {
			String imgpath= new BaseClass().capturescreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		extent.flush();
	}
	}

		
	