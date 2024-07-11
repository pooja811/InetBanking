package com.inetbanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentSparkReporter sprkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testcontext){
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repoName = "Test-Report-"+timestamp+".html";
		sprkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repoName);
		try {
			sprkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent_config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		extent= new ExtentReports();
		extent.attachReporter(sprkReporter);
		extent.setSystemInfo("Hostname", "Localhost");
		extent.setSystemInfo("Env", "QA");
		extent.setSystemInfo("User", "Pooja More");
		
		sprkReporter.config().setDocumentTitle("InetBanking Test Automation");
		sprkReporter.config().setReportName("Funcation Test Reporter");
		sprkReporter.config().setTheme(Theme.DARK);
			
	}
	public void onTestSuccess(ITestResult tresult) {
		logger = extent.createTest(tresult.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tresult.getName(), ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult tresult) {
		logger = extent.createTest(tresult.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tresult.getName(), ExtentColor.RED));
		
		String screentshotpath =System.getProperty("user.dir")+"\\Screenshots\\"+tresult.getName()+".png";
		
		File f = new File(screentshotpath);
		if(f.exists()) {
			logger.fail("Failed Screenshot is:"+ logger.addScreenCaptureFromPath(screentshotpath));
		}
	}
	 public void onTestskip(ITestResult tresult) {
		 logger = extent.createTest(tresult.getName());
			logger.log(Status.SKIP,MarkupHelper.createLabel(tresult.getName(), ExtentColor.YELLOW));
	 }
	public void onfinish(ITestContext testcontext) {
		extent.flush();
	}
	
}
