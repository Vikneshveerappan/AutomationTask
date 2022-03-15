package com.maven.stepdefinition;

import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.maven.baseclass.BaseClass;
import com.maven.pom.IMDBPage;
import com.maven.pom.WikiPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinitions extends BaseClass {
	static WebDriver driver;

	@Given("^user prefers to launch chrome browser$")
	public void user_prefers_to_launch_chrome_browser() throws Throwable {
		driver = browserLaunch("chrome");
	}

	@When("URL is launched in the chrome browser$")
	public void URL_is_launched_in_the_chrome_browser() throws Throwable {
		launchURL("https://www.google.com");
	}

	@Given("^User navigate to '(.*)' page$")
	public void user_navigate_to_https_www_imdb_com_title_tt_page(String arg1) throws Throwable {
		navigateTo(arg1);
	}

	static Map<String, String> mp = new HashMap<String, String>();

	@Given("^User get release date from imdb page$")
	public void user_get_release_date_from_imdb_page() throws Throwable {
		IMDBPage im = new IMDBPage(driver);
		String releaseDate = getElementText(im.getReleaseDate());
		mp.put("IMDBReleaseDate", releaseDate);
	}

	@Given("^User get country of origin from imdb page$")
	public void user_get_country_of_origin_from_imdb_page() throws Throwable {
		IMDBPage im = new IMDBPage(driver);
		String countryOrigin = getElementText(im.getCountryOrigin());
		mp.put("IMDBCountryOrigin", countryOrigin);
	}

	@Given("^User get release date from wiki page$")
	public void user_get_release_date_from_wiki_page() throws Throwable {
		WikiPage wi = new WikiPage(driver);
		String releaseDate = getElementText(wi.getReleaseDate());
		mp.put("WIKIReleaseDate", releaseDate);

	}

	@Given("^User get country of origin from wiki page$")
	public void user_get_country_of_origin_from_wiki_page() throws Throwable {
		WikiPage wi = new WikiPage(driver);
		String countryOrigin = getElementText(wi.getCountryOrigin());
		mp.put("WIKICountryOrigin", countryOrigin);

	}

	@Given("^User compare both imdb and wiki data for release date and country of origin$")
	public void user_compare_both_imdb_and_wiki_data_for_release_date_and_country_of_origin() throws Throwable {
		System.out.println(mp);
		Date date1 = new SimpleDateFormat("dd MMMM yyyy").parse(mp.get("WIKIReleaseDate"));
		SimpleDateFormat sd = new SimpleDateFormat("MMMM dd, yyyy");
		String releaseFormattedate = sd.format(date1);
		org.junit.Assert.assertEquals(mp.get("WIKICountryOrigin"), mp.get("IMDBCountryOrigin"));

		org.junit.Assert.assertEquals(releaseFormattedate,
				mp.get("IMDBReleaseDate").replace("(United States)", "").trim());

	}

}
