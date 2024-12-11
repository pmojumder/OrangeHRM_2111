package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.DriverUtilis;

public class BasePage {
	WebDriver driver;

	public BasePage()
	{
	driver=DriverUtilis.getDriver();
	PageFactory.initElements(driver,this);
	}
}
