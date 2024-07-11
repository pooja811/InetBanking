package com.inetbanking.PageObajects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage  {
	WebDriver ldriver;
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement addcustomer;
	
	@FindBy(xpath="//input[@name='name']")
	@CacheLookup 
	WebElement custname;
	
	@FindBy(xpath="//input[@value='m']")
	@CacheLookup
	WebElement gendermale;
	
	@FindBy(xpath="//input[@value='f']")
	@CacheLookup
	WebElement genderfemale;
	
	@FindBy(xpath="//input[@id='dob']")
	@CacheLookup
	WebElement dob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	
	public void addcust() {
		addcustomer.click();
	}
	public void addcustname(String cname) {
		custname.sendKeys(cname);
	}
	public void addcustgnder(String cgender) {
		if(cgender.equalsIgnoreCase("female")) {
			genderfemale.click();
		}
		else if(cgender.equalsIgnoreCase("male")) {
			gendermale.click();
		}		
	}
	public void addcustdob(String dd,String mm,String yy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yy);
		
	}
	public void addcustaddress(String add ) {
		address.click();
		address.sendKeys(add);
	}
	public void addcustcity(String ccity) {
		city.sendKeys(ccity);
	}
	public void addcuststate(String cstate) {
		state.sendKeys(cstate);
	}
	public void addcustpin(String cpin) {
		pin.sendKeys(cpin);
	}
	public void addcustmob(String cmobile) {
		mobile.sendKeys(cmobile);
	}
	public void addcustemail(String cemail) {
		email.sendKeys(cemail);
	}
	public void addcustpass(String cpwd) {
		password.sendKeys(cpwd);
	}
	public void submitclick() {
		submit.click();;
	}
}
