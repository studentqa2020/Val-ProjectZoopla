package com.cucumber;

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

public class CucumberBaseLogin {
	
	public static LoginPage login;
	
	public static WebDriver setupBrowser() {		
	
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		WebDriver driver = new ChromeDriver();
		
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        return driver;

	}
	
	public static void getUrl(WebDriver driver) throws Throwable {
		driver.get(BaseConfig.getconfig("URL"));
	}
	
	public static void clickCookies(WebDriver driver) {
		login =new LoginPage(driver);
	    login.getCookies().click();
	    System.out.println(driver.getTitle());
	}
	
	public static void clickSignIn(WebDriver driver) {  
       
       new TakeAppScreenShot();
		TakeAppScreenShot.captureScreenShot(driver, "Login Page");
       
       login.getLogin().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

	}
	
	public static void enterUserName(WebDriver driver) throws Throwable {
		Wait.getExplicitWaitClicable(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		new TakeAppScreenShot();
		TakeAppScreenShot.captureScreenShot(driver, "Val Login Page");
		
	}
	
	public static void enterPassword(WebDriver driver) throws Throwable {
		new Highlighter().getcolor(driver, login.getPass(),"red");
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
		
		new TakeAppScreenShot();
		TakeAppScreenShot.captureScreenShot(driver, "Val Login Page");	
		
	}
	
	public static void logIn(WebDriver driver) {
		login.getSubmit().click();
	}
	
	public static void loginSuccessfull(WebDriver driver) {
		System.out.println(driver.getTitle());
	}
}
	