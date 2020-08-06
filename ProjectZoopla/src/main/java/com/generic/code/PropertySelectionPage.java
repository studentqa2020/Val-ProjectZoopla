package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.PropertySelectionPageFactory;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class PropertySelectionPage extends BaseLogin{
	
public static void selectProperty() throws Throwable{
	
	getLogin();
	System.out.println(driver.getTitle());
	
 		
	PropertySelectionPageFactory propertySelectionPf = new PropertySelectionPageFactory(driver);
	
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
	propertySelectionPf.getSearchBtn().click();
	
	
	if(propertySelectionPf.getLogoImage().isDisplayed()) {
		System.out.println("Image is present");
	} else {
		System.out.println("Image is not prosent");
	}
	 
	
	Actions zooplaBtn = new Actions(driver);
	zooplaBtn.moveToElement(propertySelectionPf.getZooplalogout()).build().perform(); // move mouse over My Zoopla Btn
	
	Actions zooplasignoutBtn = new Actions(driver);
	zooplasignoutBtn.moveToElement(propertySelectionPf.getZooplaSignout()).build().perform();
	TakeAppScreenShot.captureScreenShot(driver, "Signout ");
	propertySelectionPf.getZooplaSignout().click();
	
	
//	driver.quit();
}	
	
}

	
	


