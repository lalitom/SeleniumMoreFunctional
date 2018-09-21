package DatProvider.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
	
	WebDriver driver;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@BeforeTest
	public void setup()
	{
		 System.setProperty("webdriver.chrome.driver", "D:\\Setups and jars\\chromedriver_win32\\chromedrivernew\\chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.get("http://www.vpl.ca");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@Test(enabled=false)
	public void enterFieldtest() 
	{
		
		String typeKeywordJS;
		typeKeywordJS =
		"document.getElementById('globalQuery').value='java'";
		js.executeScript(typeKeywordJS);
	}
	
	@Test(enabled=false)
	public void searchbuttontest()
	{
		
		String clickSearchButtonJS;
		clickSearchButtonJS =
		"document.querySelector(\"[class='search_button']\")" +
		".click()";
		js.executeScript(clickSearchButtonJS);
	}

	@Test
	public void jsQuerytest()
	{
		
		By searchbutton=By.name("search");
	String jsQuery =
			String.format("%s.style.backgroundColor='red'", searchbutton);

	js.executeScript(jsQuery);
	}
}
