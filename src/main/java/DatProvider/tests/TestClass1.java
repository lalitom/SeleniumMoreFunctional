package DatProvider.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass1 {
	
	WebDriver driver;
	By searchTextBoxLocator = By.id("edit-search");
	By searchButtonLocator = By.xpath("//input[@class='search_button']");
	By firstResultLocator = By.xpath("(//a[@testid='bib_link'])[1]");
	By resultTitleLocator = By.id("item_bib_title");

	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Setups and jars\\chromedriver_win32\\chromedrivernew\\chromedriver.exe");
	driver = new ChromeDriver();
	}

	@After
	public void tearDown(){
	driver.quit();
	}

	public void delay(int num) throws InterruptedException
	{
		num=num+Integer.parseInt("000");
		Thread.sleep(num);
	}
	@Test
	public void testWithSelenium() throws InterruptedException
	{
	driver.get("http://www.vpl.ca");

	WebElement searchField;
	searchField = driver.findElement(searchTextBoxLocator);
	searchField.click();
	searchField.sendKeys("java");

	WebElement searchButton;
	searchButton = driver.findElement(searchButtonLocator);
	searchButton.click();

	delay(5);

	WebElement searchResultLink;
	searchResultLink = driver.findElement(firstResultLocator);
	searchResultLink.click();

	delay(5);

	WebElement bookTitleElement;
	bookTitleElement = driver.findElement(resultTitleLocator);
	String bookTitleValue;
	bookTitleValue = bookTitleElement.getText();
	assertTrue(bookTitleElement.isDisplayed() == true);
	assertTrue(bookTitleValue.length() > 0);
	
	}
	

}
