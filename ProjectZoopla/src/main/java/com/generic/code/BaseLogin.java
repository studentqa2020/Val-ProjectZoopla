package com.generic.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;



public class BaseLogin {
	protected static WebDriver driver;
	
	public static void getLogin() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		driver = new ChromeDriver();
		
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(BaseConfig.getconfig("URL"));
        
        LoginPage login =new LoginPage(driver);
        login.getCookies().click();
        System.out.println(driver.getTitle());
        
        new TakeAppScreenShot();
		TakeAppScreenShot.captureScreenShot(driver, "Login Page");
        
        login.getLogin().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		Wait.getExplicitWaitClicable(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		new TakeAppScreenShot();
		TakeAppScreenShot.captureScreenShot(driver, "Val Login Page");
		
		new Highlighter().getcolor(driver, login.getPass(),"red");
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
		
		new TakeAppScreenShot();
		TakeAppScreenShot.captureScreenShot(driver, "Val Login Page");	
		
	    login.getSubmit().click();
		
			
	}
	
	
	
}


	
