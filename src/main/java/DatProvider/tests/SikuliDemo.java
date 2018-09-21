package DatProvider.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

public class SikuliDemo {
	WebDriver driver=null;
	
	@BeforeTest
	public void setup()
	{
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups and jars\\chromedriver_win32\\chromedrivernew\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void SkiuliImageClickTest() throws FindFailed, AWTException
	{
		Screen sc= new Screen();
		Pattern image=new Pattern("D:\\Setups and jars\\sikuliscreenshots\\GoogleSearchButton.PNG");
        driver.findElement(By.name("q")).sendKeys("1234");
        Actions actions = new Actions(driver);

        Robot robot = new Robot();
        robot.mouseMove(50,50);
        actions.click().build().perform();
        sc.wait(image, 10);
        sc.click(image);
		
		
		
		
		
	}
	
	
	
	

}
