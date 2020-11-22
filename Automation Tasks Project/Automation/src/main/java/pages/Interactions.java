package pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Interactions {

	public static String fileWithPath = "C:\\Users\\user\\eclipse-workspace2Maven\\WebdriverTest\\screenshots\\screenshot.png";

	// Xpaths

	public static String droppableXpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/ul[1]/li[4]";

	public static String dropHereXpath = "//div[@id='simpleDropContainer']//div[@id='droppable']";

	public static String dragMeXpath = "//div[@id='draggable']";

	/* public static String droppedXpath= "//p[contains(text(),'Dropped!')]"; */

	public static String widgetsXpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]/div[1]";

	// WebElements

	public static WebElement getDroppable(WebDriver wd) {
		return wd.findElement(By.xpath(droppableXpath));
	}

	public static WebElement getDropHere(WebDriver wd) {
		return wd.findElement(By.xpath(dropHereXpath));
	}

	public static WebElement getDragMe(WebDriver wd) {
		return wd.findElement(By.xpath(dragMeXpath));
	}

	/*
	 * public static WebElement getDropped(WebDriver wd) { return
	 * wd.findElement(By.xpath(droppedXpath)); }
	 */

	public static WebElement getWidgets(WebDriver wd) {
		return wd.findElement(By.xpath(widgetsXpath));
	}

//Methods

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

}