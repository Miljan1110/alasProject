package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaMain {

	// Xpath

	public static String interactionsXpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]";

	// WebElement

	public static WebElement getInteractions(WebDriver wd) {
		return wd.findElement(By.xpath(interactionsXpath));
	}
}
