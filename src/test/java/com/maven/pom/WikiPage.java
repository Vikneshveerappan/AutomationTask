package com.maven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {

	static WebDriver driver;

	@FindBy(xpath = "//div[text()='Release date']//parent::th//following-sibling::td//li")
	private WebElement releaseDate;

	@FindBy(xpath = "//th[text()='Country']//following-sibling::td")
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

	public WikiPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}
}
