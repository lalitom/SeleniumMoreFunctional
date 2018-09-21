package DatProvider.tests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By searchFieldXpath = By.id("globalQuery");
	By searchButtonXpath = By.className("search_button");

	By resultLinkLocator = By.xpath("(//a[@testid='bib_link'])[1]");	

	String homeUrl = "http://www.vpl.ca"; 
	String homeTitle = "Vancouver Public Library - Home";

	String resultsTitle = "Search | Vancouver Public Library | BiblioCommons";
	String resultsUrl = "https://vpl.bibliocommons.com/search";
	@Before
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Setups and jars\\chromedriver_win32\\chromedrivernew\\chromedriver.exe");	
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 10);
			
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void test1Test(){
		driver.get(homeUrl);
		
if (!wait.until(ExpectedConditions.titleContains(homeTitle)) || !wait.until(ExpectedConditions.urlContains(homeUrl)))
{
				throw new RuntimeException("home page is not displayed");			
		
}

	WebElement searchField=wait.until(ExpectedConditions.elementToBeClickable(searchFieldXpath));
	searchField.click();
	CharSequence keyword="12234";
	searchField.sendKeys(keyword);
    WebElement searchButton= wait.until(ExpectedConditions.elementToBeClickable(searchButtonXpath));
    searchButton.click();

    if (!wait.until(ExpectedConditions.titleContains(resultsTitle)) || !wait.until(ExpectedConditions.urlContains(resultsUrl)))
		throw new RuntimeException("results page is not displayed");
	
}	
	
}
	

