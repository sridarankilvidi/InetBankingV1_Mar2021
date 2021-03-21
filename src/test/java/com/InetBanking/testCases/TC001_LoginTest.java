package com.InetBanking.testCases;

import java.io.IOException;

//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass{
	
	
	@Test
	public void LoginTest() throws IOException {

		log.info("banking app is open");
		
		// create an instance of bank loginpage object
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		//GTPL Bank Manager HomePage - title validation 
		// that login is successful or not
		System.out.println(driver.getTitle());
	
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("banking-app login is successful");
		}
		else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			log.info("banking-app login is NOT successful");
		}
		
		
	}
}

