package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefinitions {

	public WebDriver driver;

	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) 
		{

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox"))
		{

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge"))
		{

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		}

		

	}

	@Given("user launch app using url {string}")
	public void user_launch_app_using_url(String url) {
		
		driver.get(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@When("user enters text {string} using xpath {string}")
	public void user_enters_text_using_xpath(String text, String xpath) {
		
		driver.findElement(By.xpath(xpath)).sendKeys(text);

	}

	@When("user clicks button using xpath {string}")
	public void user_clicks_button_using_xpath(String xpath) {
		
		driver.findElement(By.xpath(xpath)).click();

	}

	@Then("user validates URL to  be {string}")
	public void user_validates_url_to_be(String expURL) {
		
		
		Assert.assertEquals(driver.getCurrentUrl(), expURL);
	}
	
	@After
	public void teardown()
	{
		driver.quit();
		
	}
	
	

@When("user clicks linktext using xpath {string}")
public void user_clicks_linktext_using_xpath(String xpath) {
	
	driver.findElement(By.xpath(xpath)).click();
   
}
@When("user enters details in Registration form")
public void user_enters_details_in_registration_form(DataTable dataTable) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	
	List<List<String>> allData=dataTable.asLists();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(allData.get(0).get(0));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(allData.get(0).get(1));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(allData.get(0).get(2));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(allData.get(0).get(3));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(allData.get(0).get(4));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(allData.get(0).get(5));
	Thread.sleep(3000);
   
}

@When("user enters details in Registration form2")
public void user_enters_details_in_registration_form2(DataTable dataTable) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	
	//| username | password |  confirm Password | full name | email address | captcha|
	List<Map<String, String>> allData=dataTable.asMaps();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(allData.get(0).get("username"));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(allData.get(0).get("password"));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(allData.get(0).get("confirm Password"));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(allData.get(0).get("full name"));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(allData.get(0).get("email address"));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(allData.get(0).get("captcha"));
	Thread.sleep(3000);
	
   
}


	
	
	
	
	
	
	
	
	
	
	
	

}
