package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	private Properties prop;

	/*
	 * public void readConfig() throws FileNotFoundException { prop = new
	 * Properties();
	 * 
	 * 
	 * 
	 * try { File configFile = new File(
	 * "C:\\Users\\Abhishek_Rana\\eclipse-workspace\\inetBankingV3\\Configuration\\config.properties"
	 * );
	 * 
	 * FileInputStream fis = new FileInputStream(configFile); prop.load(fis); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	
	 public ReadConfig() {
	        // Initialize prop here to avoid NullPointerException
	        prop = new Properties();
	        try {
	            // Load properties from config file
	            File configFile = new File("C:\\Users\\Abhishek_Rana\\eclipse-workspace\\inetBankingV3\\Configuration\\config.properties");
	            FileInputStream fis = new FileInputStream(configFile);
	            prop.load(fis);
	            fis.close(); // Close the input stream
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	public String getBaseUrl() {
		if(prop==null) {
			throw new IllegalStateException("Properties object has not been initializedddd");
		}
		String baseUrl = prop.getProperty("baseUrl");
		return baseUrl;
	}

	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

}
