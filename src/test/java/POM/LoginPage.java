package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	//Declaration

	@FindBy(xpath="//input[@name='username']")
	WebElement txtusername;
	

	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement buttonLogin;
	
	//Initialization
	
	

	//Utilization
	
	public void verifyUsername(String str)
{
		txtusername.sendKeys(str);
}
	
	public void verifyPassword(String str)
{
		txtPassword.sendKeys(str);
}
	
	public void buttonclick()
	{
		buttonLogin.click();
	}
}
