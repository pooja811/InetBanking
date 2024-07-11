package com.inetbanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.PageObajects.LoginPage;


public class TC_login001 extends TestBase{
 	@Test
	public void loginTest() {
		
		driver.get(baseURL);
		logger.info("ULR is opened");
		LoginPage lp=new LoginPage(driver); 
		lp.setUserName(userName);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("TestCase PASSED");
			
		}else {
			Assert.assertTrue(false);
			logger.info("TestCase FAILED");
		}
		
		
		
	}
 	
	

}
