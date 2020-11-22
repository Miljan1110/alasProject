package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHrmDash {

	public static String recruitmentXpath = "//body/div[@id='wrapper']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/ul[1]/li[6]/a[1]/span[2]";

	public static String candidatesXpath = "//span[contains(text(),'Candidates')]";

	public static String candidatesTotalXpath = "//div[contains(text(),'1 - 10 of 37')]";

	public static String addXpath = "//i[contains(text(),'add')]";

	public static String sideMenuXpath = "//a[@id='side-menu-hamburger']";

	public static String threeDotsXpath = "//i[contains(text(),'more_horiz')]";

	public static String deleteItemXpath = "//a[@id='deleteItemBtn']";

	public static String userXpath = "//i[contains(text(),'keyboard_arrow_down')]";

	public static String logoutXpath = "//a[@id='logoutLink']";

	public static WebElement getRecruitment(WebDriver wd) {
		return wd.findElement(By.xpath(recruitmentXpath));
	}

	public static WebElement getCandidates(WebDriver wd) {
		return wd.findElement(By.xpath(candidatesXpath));
	}

	public static WebElement getCandidatesTotal(WebDriver wd) {
		return wd.findElement(By.xpath(candidatesTotalXpath));
	}

	public static WebElement getAdd(WebDriver wd) {
		return wd.findElement(By.xpath(addXpath));
	}

	public static WebElement getSideMenu(WebDriver wd) {
		return wd.findElement(By.xpath(sideMenuXpath));
	}

	public static WebElement getThreeDots(WebDriver wd) {
		return wd.findElement(By.xpath(threeDotsXpath));
	}

	public static WebElement getDeleteItem(WebDriver wd) {
		return wd.findElement(By.xpath(deleteItemXpath));
	}

	public static WebElement getUser(WebDriver wd) {
		return wd.findElement(By.xpath(userXpath));
	}

	public static WebElement getLogout(WebDriver wd) {
		return wd.findElement(By.xpath(logoutXpath));
	}

}
