package com.page.object.model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertySelectionPageFactory {

	public PropertySelectionPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='search-input-location']")
	private WebElement Location;

	@FindBy(xpath = "//*[@class='button button--primary']")
	private WebElement searchBtn;

	@FindBy(xpath = "//*[@class='listing-results-price text-price']")
	private List<WebElement> listprice;

	// @FindBy(xpath = "//img[@alt='Marketed by Parkmove']")
	@FindBy(xpath = "//img[@class='js-lazy-loaded']")
	private WebElement LogoImage;

	// @FindBy(xpath = "//*[@class='account-link__text']")
	@FindBy(xpath = "(//*[text()='My Zoopla'])[1]")
	private WebElement zooplalogout;

	// @FindBy(xpath = "//*[@class='icon--signout']")
	@FindBy(xpath = "(//div[@content='Sign out'])[1]")
	private WebElement zooplaSignout;

	public WebElement getLocation() {
		return Location;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLogoImage() {
		return LogoImage;
	}

	public List<WebElement> getListprice() {
		return listprice;
	}

	public WebElement getZooplalogout() {
		return zooplalogout;
	}

	public WebElement getZooplaSignout() {
		return zooplaSignout;
	}
}
