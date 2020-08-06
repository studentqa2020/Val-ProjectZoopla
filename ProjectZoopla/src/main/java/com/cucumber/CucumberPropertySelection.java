package com.cucumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.PropertySelectionPageFactory;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class CucumberPropertySelection {
	
	public static PropertySelectionPageFactory propertySelectionPf;
	
	public static void selectProperty(WebDriver driver) throws Throwable {
		
		propertySelectionPf = new PropertySelectionPageFactory(driver);
		
		new Highlighter().getcolor(driver, propertySelectionPf.getLocation(),"yellow");
		Wait.getExplicitWaitClicable(driver, propertySelectionPf.getLocation());
		propertySelectionPf.getLocation().sendKeys(BaseConfig.getconfig("Location"));		
			
		Wait.getExplicitWaitClicable(driver, propertySelectionPf.getSearchBtn());
		new Highlighter().getcolor(driver, propertySelectionPf.getSearchBtn(), "red");
		TakeAppScreenShot.captureScreenShot(driver, "Search Window ");
		propertySelectionPf.getSearchBtn().click();
		
		
		List<WebElement> homePrice = propertySelectionPf.getListprice(); 
		System.out.println(homePrice);
		String[] myPrice;
		List<Integer> myIntPrice = new ArrayList<>();
		
		for(int i=0;i<homePrice.size();i++) {
			myPrice = homePrice.get(i).getText().split(" ");
		
			myIntPrice.add(Integer.parseInt(myPrice[0].replace("£","" ).replace(",", "")));
		}
		System.out.println(myIntPrice);
		Collections.sort(myIntPrice);
		System.out.println("This is sorted Asc: "+myIntPrice);
		Collections.reverse(myIntPrice);
		System.out.println("This is sorted Desc: "+myIntPrice);		
		homePrice.get(4).getText(); //for 5th property index would be 4
		homePrice.get(4).click();
		
		TakeAppScreenShot.captureScreenShot(driver, "House 4 agent details and phone ");
	}
	
	public static void getAgentInfo(WebDriver driver) {
		
		Wait.getExplicitWaitVisible(driver, propertySelectionPf.getLogoImage());
		if(propertySelectionPf.getLogoImage().isDisplayed()) {
			System.out.println("Image is present");
		} else {
			System.out.println("Image is not prosent");
		}
		// display agent name and contact info
	}
	
	public static void singOut(WebDriver driver) {
		Actions zooplaBtn = new Actions(driver);
		zooplaBtn.moveToElement(propertySelectionPf.getZooplalogout()).build().perform(); // move mouse over My Zoopla Btn
		
		Actions zooplasignoutBtn = new Actions(driver);
		zooplasignoutBtn.moveToElement(propertySelectionPf.getZooplaSignout()).build().perform();
		TakeAppScreenShot.captureScreenShot(driver, "Signout ");
		propertySelectionPf.getZooplaSignout().click();		
//		driver.quit();
	}

}
