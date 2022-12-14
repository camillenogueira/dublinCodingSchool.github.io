import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Test Scenario to test new customer functionality")
public class newCustomer_TestScenarios {
	
	//Declaration of the object webdriver
		public static WebDriver driver = null;
		
		
		@BeforeAll
		public static void beforeAll() {
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		
		}
		
		@AfterAll
		public static void afterAll() {
			//driver.close();
			//driver.quit();
		}
		
		@Test
		@DisplayName("Check results on entering a valid information for all fields")
		public void addCustomer_happyPath() throws InterruptedException {
			
			// =======================================
			// Pre condition - Login Functionality 
			// =======================================
			
			//Data to be used in this test
			String userID = "mngr444684";
			String password = "ypadYdu";
			
			//Open the URL
			driver.get("https://demo.guru99.com/v4");
			driver.manage().window().maximize();
			Thread.sleep(5000); //wait for 5 seconds to execute the next line of code
			
			driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
			
			Thread.sleep(3000);
			//Enter the user ID
			driver.findElement(By.name("uid")).sendKeys(userID);
			
			//Enter the password
			driver.findElement(By.name("password")).sendKeys(password);
			
			//Click on submit
			driver.findElement(By.name("btnLogin")).click();
			// =======================================
			// =======================================
			
			String customerName = "Adam";
			String gender = "male";
			String dob = "01/01/1991";
			String expectedDOB = "1991-01-01";
			String address = "47 Testing Road";
			String city = "Dublin";
			String state = "Dublin";
			String pin = "1234567";
			String mobileNumber = "1234567";
			
			Random random = new Random();
			int randonEmail = random.nextInt(100000);
			
			System.out.println(randonEmail); //9999
			
			String email = "adam"+randonEmail+"@guru.ie";
			System.out.println(email);
			
			String customer_password = "1234567";
			
			//Click on New Customer
			driver.findElement(By.linkText("New Customer")).click();
			//driver.findElement(By.partialLinkText("Customer")).click();
			driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
			
			//Enter the Customer Name
			driver.findElement(By.name("name")).sendKeys(customerName);
			
			//Click on the gender (Male)
			driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(1)")).click();
			
			//Enter the DoB
			driver.findElement(By.id("dob")).sendKeys(dob);
			
			//Enter the address
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")).sendKeys(address);
			
			//Enter the city
			driver.findElement(By.name("city")).sendKeys(city);
			
			//Enter State
			driver.findElement(By.name("state")).sendKeys(state);
			
			//Enter PIN
			driver.findElement(By.name("pinno")).sendKeys(pin);
			
			//Enter Mobile Number
			driver.findElement(By.name("telephoneno")).sendKeys(mobileNumber);
			
			//Enter email
			driver.findElement(By.name("emailid")).sendKeys(email);
			
			//Enter Password
			driver.findElement(By.name("password")).sendKeys(customer_password);
			
			//Click on Submit 
			driver.findElement(By.name("sub")).click();
			
			
			//Check if the customer was created successfully
			String expectedResults = "Customer Registered Successfully!!!";
			String actualResults = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(1) > td > p")).getText();
			assertEquals(expectedResults,actualResults);
			
			
			//Check if all inputs is presented as expected
			//check the customer name
			assertEquals(customerName, driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText());
			//Check gender
			assertEquals(gender, driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]")).getText());
			//Check DOB
			assertEquals(expectedDOB, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(7) > td:nth-child(2)")).getText());
			//check address
			assertEquals(address, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(8) > td:nth-child(2)")).getText());
			//check city
			assertEquals(city, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(9) > td:nth-child(2)")).getText());
			
			//check state
			
			//check pin
			
			//check mobile number
			
			//check email
			
			
		}
	
	
}
