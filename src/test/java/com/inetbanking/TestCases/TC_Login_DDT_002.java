package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObajects.LoginPage;
import com.inetbanking.Utilities.XLUtils;

public class TC_Login_DDT_002 extends TestBase{
	
	@Test(dataProvider ="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user  entered");
		lp.setPassword(pwd);
		logger.info("password entered");
		lp.clickLogin();
		logger.info("login clicked");
		Thread.sleep(3000);
		
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept(); //close alert
			logger.info("alert closed");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			logger.info("logout clicked");
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert
			logger.info("alert closed");
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() { //user defined method to check alert
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name="LoginData")
	 String[][] getdata() throws IOException{
		String path= System.getProperty("user.dir")+"/src/test/java/com/inetbanking/TestData/LoginData.xlsx";
		int rownum =XLUtils.getRowCount(path, "Data");
		int colncount =XLUtils.getCellCount(path, "Data", 1);
		
		String logindata[][]=  new String[rownum][colncount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0; j<colncount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path,"Data", i, j); 
			}
		}
		return logindata;
		
	}
}
