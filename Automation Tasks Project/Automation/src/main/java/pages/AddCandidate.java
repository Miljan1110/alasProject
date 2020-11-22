package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCandidate {

	public static String resumeXpath = "//input[@id='addCandidate_resume']";

	public static String firstNameXpath = "//input[@id='addCandidate_firstName']";

	public static String lastNameXpath = "//input[@id='addCandidate_lastName']";

	public static String emailXpath = "//iframe[@id='noncoreIframe']";

	public static String calendarXpath = "//body/div[@id='wrapper']/div[@id='right-side']/div[@id='content']/div[@id='modalAddCandidate']/div[2]/form[1]/div[5]/div[2]/div[1]/div[1]";

	public static String saveXpath = "//a[@id='saveCandidateButton']";

	public static WebElement getResume(WebDriver wd) {
		return wd.findElement(By.xpath(resumeXpath));
	}

	public static WebElement getFirstName(WebDriver wd) {
		return wd.findElement(By.xpath(firstNameXpath));
	}

	public static WebElement getLastName(WebDriver wd) {
		return wd.findElement(By.xpath(lastNameXpath));
	}

	public static WebElement getEmail(WebDriver wd) {
		return wd.findElement(By.xpath(emailXpath));
	}

	public static WebElement getSave(WebDriver wd) {
		return wd.findElement(By.xpath(saveXpath));
	}

}
