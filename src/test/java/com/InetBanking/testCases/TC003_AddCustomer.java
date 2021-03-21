package com.InetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.AddCustomerPage;
import com.InetBanking.pageObjects.LoginPage;

public class TC003_AddCustomer extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		log.info("User name is provided");
		lp.setPassword(password);
		log.info("Passsword is provided");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		log.info("providing customer details....");
		
		
		addcust.custName("Sridaran");
		addcust.custgender("male");
		addcust.custdob("1985","10","15");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("Chennai");
		addcust.custstate("TN");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		log.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("test case passed....");
			
		}
		else
		{
			log.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

}
