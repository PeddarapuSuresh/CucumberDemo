package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import StepDefinations.pageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Applicationdemo {
	WebDriver driver = null;

	@Given("User launch the application url")
	public void when_user_loads_application_url() {

		System.setProperty("webdriver.chrome.driver", "servers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.exercise1.com/values");

	}

	@When("^Verify the right count of values appear on the screen \"([^\"]*)\"$")
	public void verify_the_right_count_of_values_appear_on_the_screen(int ExpectedCount) {

		// Here I am showing the data driven approach with scenario outline in cucumber
		pageObjects objects = new pageObjects(driver);
		objects.VerifyingLabel_Count(ExpectedCount);
	}

	@Then("^verify the values on the screen are greater than (.*)$")
	public void verify_the_values_on_the_screen_are_greater_than(int value)  {
		pageObjects objects = new pageObjects(driver);
		objects.VerifyValuesGreaterThanZero(value);
	}

	@Then("verify the total balance is correct based on the values listed on the screen")
	public void verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen()  {
		pageObjects objects = new pageObjects(driver);
		try {
			objects.Verifytotalbalance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("verify the values are formatted as currencies")
	public void verify_the_values_are_formatted_as_currencies() {
		pageObjects objects = new pageObjects(driver);
		try {
			objects.currencyvalidator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("verify the total balance matches the sum of the values")
	public void verify_the_total_balance_matches_the_sum_of_the_values() {
		pageObjects objects = new pageObjects(driver);
		try {
			objects.Verifytotalbalance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	@When("^User is on the home page (.*)$")
	public void user_is_on_the_home_page(String Expectedpagetitle) {
		pageObjects objects = new pageObjects(driver);
		objects.Verifylandonpage(Expectedpagetitle);
	}

	@Then("Verify is prices are displaying on page")
	public void verify_is_prices_are_displaying_on_page() {
		pageObjects objects = new pageObjects(driver);
		objects.verifylabelsavalibility();
	}

	@Then("verify the values on the screen are Null")
	public void verify_the_values_on_the_screen_are_null() {
		pageObjects objects = new pageObjects(driver);
		
		objects.VerifyValuesarenull();
	}
	
	
	@And("Close the application")
	public void TearDown() {
		driver.quit();
	}

}
