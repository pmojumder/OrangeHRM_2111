package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import POM.LoginPage;
import Utils.DriverUtilis;

public class VerifyTest {
	
	@Test
	public void LoginTest()
	{
		
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Plabani\\Downloads\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();//downcasting
    DriverUtilis.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    LoginPage lp=new LoginPage();
    lp.verifyUsername("Admin");
    lp.verifyPassword("admin123");
    lp.buttonclick();
}

}
