package com.InetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.InetBanking.utilities.ReadConfig;
//import org.testng.log4testng.Logger;

public class BaseClass {
	// since we have included config.properties and readconfig.java class we can remove the
	// following variables and replace them by calling the methods in readconfig class
	
	/*public String baseURL="http://demo.guru99.com/V1/index.php";
	public String username="mngr314720";
	public String password="UregerE";
	//public String chromepath = "C://sridaran//Selenium-java//eclipse-workspace//InetBankingV1//Drivers//chromedriver.exe";
	public String chromepath = System.getProperty("user.dir")+"//Drivers//chromedriver.exe";
	*/
		///html/body/div[3]/div/ul/li[10]/a
	public static WebDriver driver;
	public static Logger log;
	
	// create and instance of readconfig class and call the methods
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username= readconfig.getUserName();
	public String password= readconfig.getPassword();
	public String chromepath = readconfig.getChromePath();
	public String firefoxpath = readconfig.getFirefoxPath();
	public String edgepath = readconfig.getEdgePath();
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String browser) {
		 log= Logger.getLogger("InetBankingV1");
	     PropertyConfigurator.configure("log4j.properties"); 
		
	     //System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe"); 
	     if (browser.equalsIgnoreCase("chrome"))
	     {
	    	 System.setProperty("webdriver.chrome.driver", chromepath);  
	    	 driver = new ChromeDriver();
	    	 log.info("Chrome Browser is used....");
	     }else if (browser.equalsIgnoreCase("firefox")){
	    	 System.setProperty("webdriver.gecko.driver", firefoxpath);  
	    	 driver = new FirefoxDriver();
	    	 log.info("Firefox Browser is used....");
	     }else if (browser.equalsIgnoreCase("edge")) {
	    	// Set the driver path
	    	 System.setProperty("webdriver.edge.driver", edgepath);
	    	 driver = new EdgeDriver();
	    	 log.info("Edge Browser is used....");
	     }
	     driver.get(baseURL);	
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	}
	
	@AfterClass
	public void TearDown() {
		log.info("Exiting the Test cycle....");
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		log.info("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
