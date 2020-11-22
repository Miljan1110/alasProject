package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMain {

	public static String GoogleUrl = "https://www.google.com/";

	// Xpaths

	public static String searchBarXpath = "//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]";

	public static String searchButtonXpath = "//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[3]/center[1]/input[1]";

	// WebElements

	public static WebElement getSearchBar(WebDriver wd) {
		return wd.findElement(By.xpath(searchBarXpath));
	}

	public static WebElement getSearchButton(WebDriver wd) {
		return wd.findElement(By.xpath(searchButtonXpath));
	}
}
