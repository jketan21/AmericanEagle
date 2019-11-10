package junitcucumber;

import java.io.FileInputStream;
import org.testng.Assert;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

public class CheckoutPaySteps {

	WebDriver driver;			



	@Given("^I launch the chrome browser$")
	public void i_launch_the_chrome_browser() throws Throwable {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/ObjectRepo.properties");
		obj.load(objfile);
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	


		driver= new ChromeDriver();					
		driver.manage().window().maximize();			
		driver.get("http://ae.com");	
		System.out.println("Test1");
		Thread.sleep(3000);
	}


	@When("^I Launch AE, select the item, checkout and execute the pay with card details \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_Launch_AE_select_the_item_checkout_and_execute_the_pay_with_card_details(String card, String exp, String cvv) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/ObjectRepo.properties");
		obj.load(objfile);
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	

		WebDriverWait wait = new WebDriverWait(driver,30);





		driver.findElement(By.xpath(obj.getProperty("close"))).click();

		driver.findElement(By.xpath(obj.getProperty("shopmen"))).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(obj.getProperty("tops"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("selectitem"))));


		driver.findElement(By.xpath(obj.getProperty("selectitem"))).click();



		driver.findElement(By.cssSelector(obj.getProperty("sizedropdown"))).click();
		driver.findElement(By.xpath(obj.getProperty("selectsize"))).click();
		driver.findElement(By.xpath(obj.getProperty("addtobag"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("viewbag"))));



		driver.findElement(By.xpath(obj.getProperty("viewbag"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("checkout"))));
		driver.findElement(By.xpath(obj.getProperty("checkout"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("checkouttext"))));

		WebElement fName = driver.findElement(By.name(obj.getProperty("fname"))); 
		fName.sendKeys("Ketan");
		WebElement lName = driver.findElement(By.name(obj.getProperty("lname"))); 
		lName.sendKeys("Jadhav");
		WebElement sAddress = driver.findElement(By.name(obj.getProperty("address"))); 
		sAddress.sendKeys("3131 Homestead Rd");
		WebElement city = driver.findElement(By.name(obj.getProperty("city"))); 
		city.sendKeys("Santa Clara");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Thread.sleep(2000);
		driver.findElement(By.xpath(obj.getProperty("statedropdown"))).click();
		driver.findElement(By.xpath(obj.getProperty("selectstate"))).click();

		WebElement zipCode = driver.findElement(By.xpath(obj.getProperty("zipcode"))); 
		zipCode.sendKeys("95010");
		WebElement cardNumber = driver.findElement(By.xpath(obj.getProperty("cardnumber"))); 
		cardNumber.sendKeys(card);
		WebElement expiry = driver.findElement(By.xpath(obj.getProperty("cardexpiry"))); 
		expiry.sendKeys(exp);
		WebElement cvvCode = driver.findElement(By.xpath(obj.getProperty("securitycode"))); 
		cvvCode.sendKeys(cvv);
		WebElement phoneNum = driver.findElement(By.xpath(obj.getProperty("phoneno"))); 
		phoneNum.sendKeys("408-232-3223");
		WebElement email = driver.findElement(By.xpath(obj.getProperty("email"))); 
		email.sendKeys("jketan21@gmail.com");
		driver.findElement(By.id(obj.getProperty("order"))).click();


		
	}

	@Then("^I verify user is not able to checkout$")
	public void i_verify_user_is_not_able_to_checkout() throws Throwable {
		String text = driver.findElement(By.xpath("carderrormsg")).getText();
		System.out.println("Message: "+text);	
        Assert.assertEquals("Please enter a valid card number.", text);
	}
	

}
