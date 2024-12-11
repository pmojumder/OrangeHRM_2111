package StepDef;

import POM.LoginPage;
import Utils.DriverUtilis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyLoginSteps {
	LoginPage lp=new LoginPage();
	@Given("Open Browser")
	public void open_browser() {
	    DriverUtilis.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("Enter Username {string} and password {string}")
	public void enter_username_and_password(String string, String string2) {
	   lp.verifyUsername("Admin");
	   lp.verifyPassword("admin123");
	}

	@When("Click Login")
	public void click_login() {
	    lp.buttonclick();
	}

	@Then("Login Successful")
	public void login_successful() {
	 System.out.println( DriverUtilis.getDriver().getTitle());
	}


}
