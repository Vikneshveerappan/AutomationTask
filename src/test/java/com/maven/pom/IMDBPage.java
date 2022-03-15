package com.maven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBPage {

	static WebDriver driver;

	@FindBy(xpath = "//li[@data-testid='title-details-releasedate']//div//a")
	private WebElement releaseDate;

	@FindBy(xpath = "//li[@data-testid='title-details-origin']//div//a")
	private WebElement countryOrigin;

	public WebElement getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(WebElement releaseDate) {
		this.releaseDate = releaseDate;
	}

	public WebElement getCountryOrigin() {
		return countryOrigin;
	}

	public void setCountryOrigin(WebElement countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	public IMDBPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}
}
