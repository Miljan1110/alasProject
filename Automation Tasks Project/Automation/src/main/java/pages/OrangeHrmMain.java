package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHrmMain {
	public static String orangeHrmUrl = "https://orangehrm-demo-6x.orangehrmlive.com/";

	public static String logInXpath = "//input[@id='btnLogin']";

	public static WebElement getLogin(WebDriver wd) {
		return wd.findElement(By.xpath(logInXpath));
	}

}
