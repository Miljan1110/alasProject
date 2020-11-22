package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Widgets {

	public static String hoverXpath = "//button[@id='toolTipButton']";
	public static String toolTipsXpath = "//span[contains(text(),'Tool Tips')]";

	// /html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[7]/span[1]
	// span[contains(text(),'Tool Tips')]

	public static String widgetsXpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]/div[1]";

	public static WebElement getHover(WebDriver wd) {
		return wd.findElement(By.xpath(hoverXpath));
	}

	public static WebElement getToolTips(WebDriver wd) {
		return wd.findElement(By.xpath(toolTipsXpath));
	}

	public static WebElement getWidgets(WebDriver wd) {
		return wd.findElement(By.xpath(widgetsXpath));
	}

}
