package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResults {

	public static String firstResultXpath = "//span[contains(text(),'Demo QA')]";
	public static String resultsNumberXpath = "//div[@id='result-stats']";

	public static WebElement getFirstResult(WebDriver wd) {
		return wd.findElement(By.xpath(firstResultXpath));
	}

	public static WebElement getResultsNumber(WebDriver wd) {
		return wd.findElement(By.xpath(resultsNumberXpath));
	}

}
