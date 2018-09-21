package DatProvider.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyImageDemo {

	WebDriver driver=null;
	@BeforeTest
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Setups and jars\\chromedriver_win32\\chromedrivernew\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void verifyImageTest()
	{
		driver.get("http://www.google.com");
		WebElement img=driver.findElement(By.cssSelector("img[alt=Google]"));
		Boolean imagePresent;
		imagePresent=(Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", img);
		
		if(imagePresent==true)
		{
			System.out.println("Image is present");
		}else
		{
			System.out.println("Image is not present");
		}
		
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	
	
}
