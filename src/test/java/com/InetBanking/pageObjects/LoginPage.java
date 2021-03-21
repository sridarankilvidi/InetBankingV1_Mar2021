package com.InetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	/**
     * All WebElements are identified by @FindBy annotation
     */
	@FindBy(name="uid")
	@CacheLookup
    WebElement txtUserName;

    @FindBy(name="password")
    @CacheLookup
    WebElement txtPassword;    

    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement btnLogin;
	
    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement lnkLogout;
   
	public LoginPage(WebDriver driver){

        this.ldriver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
    }
	
	//Set user name in textbox

    public void setUserName(String strUserName){

    	txtUserName.sendKeys(strUserName);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){

    	txtPassword.sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

    	btnLogin.click();

    }  
    
    //Click on logout after successful login

    public void clickLogout(){

    	lnkLogout.click();

    }  
    
}
