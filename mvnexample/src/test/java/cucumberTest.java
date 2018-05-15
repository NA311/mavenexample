


import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature.LogIn.feature",
		glue= "com.zensar"
				)
public class cucumberTest 
{

	public static WebDriver driver;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page()  {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.store.demoqa.com");
		}
 
	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() {
		driver.findElement(By.xpath("//*[@id='account']/a")).click();
		}
 
	@And("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password()  {
		driver.findElement(By.id("log")).sendKeys("testuser_1"); 	 
	    driver.findElement(By.id("pwd")).sendKeys("Test@123");
	    driver.findElement(By.id("login")).click();
		}
 
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully()  {
		System.out.println("Login Successfully");
	}
 
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application()  {
		driver.findElement (By.xpath("//*[@id='account_logout']/a")).click();
	}
	
	}

