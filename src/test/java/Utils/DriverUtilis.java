package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtilis {
static WebDriver driver;
	public static void createDriver()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Plabani\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	    driver=new ChromeDriver();
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static WebDriver getDriver()
	{
		if(driver== null) {
		createDriver();
		}
		return driver;
	}
}
