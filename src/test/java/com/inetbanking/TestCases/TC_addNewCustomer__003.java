package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObajects.AddNewCustomerPage;
import com.inetbanking.PageObajects.LoginPage;

public class TC_addNewCustomer__003 extends TestBase{
	@Test
	public void addCustomer() throws InterruptedException, IOException {
		logger.info("Inside TC_addNewCustomer__003.addCustomer");
		AddNewCustomerPage cp= new AddNewCustomerPage(driver);
		LoginPage lp=new LoginPage(driver); 
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("User Logged in");
		
		cp.addcust();
		logger.info("Providing new customer details");
		
		Thread.sleep(2000);
		cp.addcustname("Pooja More");
		cp.addcustgnder("female");
		cp.addcustdob("09", "12", "2023");
		Thread.sleep(3000);
		cp.addcustaddress("yashwin socity");
		cp.addcustcity("Pune");
		cp.addcuststate("Maharashtra");
		cp.addcustpin("411057");
		cp.addcustmob("8549524876");
		
		String emailid=randomvalue()+"@gmail.com";
		cp.addcustemail(emailid);
		
		cp.addcustpass("1234567");
		Thread.sleep(2000);
		cp.submitclick();
		
		if(isAlertPresent()==true) {
			String s= driver.switchTo().alert().getText();
			logger.info("alert message"+s);
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
		}
		else {
			logger.info("New Customer Created");
		}
		
		
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		Thread.sleep(5000);
		if(res==true) {
			//takescreenshot(driver,"addNewCusotmersuccess");
			Assert.assertTrue(true);
		}else
		{
			//takescreenshot(driver,"addNewCusotmerfailure");
			Assert.assertTrue(false);
		}
		
	}
	
	
	
}
