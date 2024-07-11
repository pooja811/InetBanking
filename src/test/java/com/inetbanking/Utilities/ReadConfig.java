package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop = new Properties();

	public ReadConfig() {
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	public String geturl() {
		String URL = prop.getProperty("baseURL");
		return URL;
	}

	public String getusername() {
		String uname = prop.getProperty("username");
		return uname;
	}

	public String getpassword() {
		String pword = prop.getProperty("password");
		return pword;
	}

	public String getDriverPath() {
		String driverpath = prop.getProperty("driverpath");
		return driverpath;
	}

}
