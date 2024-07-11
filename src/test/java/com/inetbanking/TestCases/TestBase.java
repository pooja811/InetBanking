package com.inetbanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.inetbanking.Utilities.ReadConfig;

public class TestBase {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.geturl();
	public String userName = readconfig.getusername();
	public String password = readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setUp() {
		//System.setProperty("webdriver.edge.driver", readconfig.getDriverPath());
		//driver = new EdgeDriver();
		System.setProperty("webdriver.chrome.driver", readconfig.getDriverPath());
		ChromeOptions options =new ChromeOptions();
		options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		driver = new ChromeDriver(options);
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		logger = Logger.getLogger("E-Banking");
		PropertyConfigurator.configure("Log4j.properties");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomvalue() {
		String genaratedvalue = RandomStringUtils.randomAlphabetic(8);
		return genaratedvalue;
	}

	public void takescreenshot(WebDriver driver, String tname) throws IOException {
		logger.info("Inside TestBase.takscreenshot");
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("./Screenshots/" + tname + ".png"));
		FileUtils.copyFile(source, target);
		logger.info("screenshot taken");
	}

	public boolean isAlertPresent() { // user defined method to check alert
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
