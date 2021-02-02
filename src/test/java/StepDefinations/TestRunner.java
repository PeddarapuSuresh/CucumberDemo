package StepDefinations;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = { "StepDefinations" },

		monochrome = true, plugin = { "pretty", "html:target/HtmlReports/report.html" })

public class TestRunner {
	static WebDriver driver;
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}
