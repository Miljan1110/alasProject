package testsPackage;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import net.bytebuddy.matcher.FailSafeMatcher;

import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertThat;

import pages.AddCandidate;
import pages.DemoqaMain;
import pages.GoogleMain;
import pages.GoogleResults;
import pages.Interactions;
import pages.OrangeHrmDash;
import pages.OrangeHrmMain;
import pages.Widgets;

public class Tests {

	private static final String OutputType = null;
	// private static SoftAssert sa = new SoftAssert();
	// private static WebDriver wd=new ChromeDriver();
	private static WebDriver wd = new FirefoxDriver();
	JavascriptExecutor js = (JavascriptExecutor) wd;

	@BeforeEach
	public static void setDriver() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		wd.manage().window().maximize();
	}

	@Test
	public void test1() throws Exception {

		wd.get(GoogleMain.GoogleUrl);
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement searchBar = wd.findElement(By.xpath(GoogleMain.searchBarXpath));
		GoogleMain.getSearchBar(wd).sendKeys("demoqa.com");
		GoogleMain.getSearchButton(wd).click();
		GoogleResults.getFirstResult(wd).click();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DemoqaMain.getInteractions(wd).click();

		js.executeScript("arguments[0].scrollIntoView();", Interactions.getDroppable(wd));
		Interactions.getDroppable(wd).click();

		Actions action = new Actions(wd);

		action.dragAndDrop(Interactions.getDragMe(wd), Interactions.getDropHere(wd)).perform();

		// clickAndHold(Interactions.getDragMe(wd))
		Interactions.takeSnapShot(wd, Interactions.fileWithPath);

		WebElement dropped = wd.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));

		System.out.println(dropped.getText());

		Interactions.getWidgets(wd).click();

		js.executeScript("arguments[0].scrollIntoView();", Widgets.getToolTips(wd));

		Widgets.getToolTips(wd).click();

		WebElement hover = wd.findElement(By.xpath("//button[@id='toolTipButton']"));

		// action.moveToElement(hover).perform();

		String actualTooltip = hover.getAttribute("aria-describedby");

		// WebElement hovered = wd.findElement(By.cssSelector(".tooltiptext"));

		// String toolTipText = hovered.getText();
		System.out.println(actualTooltip);

	}

	@Test
	public void test2() {

		wd.get(GoogleMain.GoogleUrl);
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement searchBar = wd.findElement(By.xpath(GoogleMain.searchBarXpath));
		GoogleMain.getSearchBar(wd).sendKeys("cheese");
		GoogleMain.getSearchBar(wd).sendKeys(Keys.ENTER);

		String results = GoogleResults.getResultsNumber(wd).getText().split(" ")[1];
		System.out.println(results);
		String resultsString = results.replace(".", "");

		int numberResults = Integer.parseInt(resultsString);
		System.out.println(numberResults);

		assertEquals("There is too much cheese on the internet", 777, numberResults);

	}

	@Test
	public void test3() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) wd;

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dateToday = dateFormat.format(date);

		wd.get(OrangeHrmMain.orangeHrmUrl);

		OrangeHrmMain.getLogin(wd).click();
		Thread.sleep(4000);
		wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		OrangeHrmDash.getRecruitment(wd).click();

		Thread.sleep(8000);
		wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		OrangeHrmDash.getCandidates(wd).click();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement scroll = wd.findElement(
				By.xpath("//body/div[@id='wrapper']/div[@id='right-side']/div[@id='content']/div[7]/div[1]"));

		Thread.sleep(4000);
		scroll.sendKeys(Keys.PAGE_DOWN);

		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);
		/*
		 * WebElement element = wd.findElement(By.xpath(
		 * "/html[1]/body[1]/div[1]/div[2]/div[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[1]"
		 * )); js.executeScript("arguments[0].scrollIntoView();", element);
		 */

		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String str = OrangeHrmDash.getCandidatesTotal(wd).getText().split("of ")[1];
		System.out.println(str);

		int candidatesNumber = Integer.parseInt(str);
		System.out.println(candidatesNumber);

		OrangeHrmDash.getAdd(wd).click();

		AddCandidate.getResume(wd).sendKeys("\"C:\\Users\\user\\Desktop\\CV EMPTY.docx\"");
		AddCandidate.getFirstName(wd).sendKeys("QA AUTOMATION - " + dateToday);

		AddCandidate.getLastName(wd).sendKeys("Doe");

		AddCandidate.getEmail(wd).sendKeys("johndoe@gmail.com");
		AddCandidate.getSave(wd).click();

		// New Candidate is not added

		String strAdded = OrangeHrmDash.getCandidatesTotal(wd).getText().split("of ")[1];
		int candidatesNumberAdded = Integer.parseInt(str);

		assertEquals(candidatesNumber + 1, candidatesNumberAdded);

		OrangeHrmDash.getUser(wd).click();
		OrangeHrmDash.getLogout(wd).click();

	}

	@AfterAll

	public static void closeDriver() throws InterruptedException {
		wd.close();
		wd.quit();

	}
}