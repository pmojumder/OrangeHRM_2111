package StepDef;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Plabani\\eclipse-workspace\\OrangeHRM_2111\\src\\test\\resources\\Feature",glue = "Stepdef",plugin = "html:target/cucumber.html")
public class Ru {

}
