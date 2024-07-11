package com.inetbanking.PageObajects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	@FindBy(name="btnLogin")
	WebElement login;
	@FindBy(name="btnReset")
	WebElement reset;
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	public void setPassword(String passw) {
		password.sendKeys(passw);
	}
	public void clickLogin() {
		login.click();
	}
	public void clickLogout() {
		logout.click();
	}
	
}
