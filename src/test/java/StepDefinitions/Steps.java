package StepDefinitions;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import Pageobjects.Registration;


@SuppressWarnings("deprecation")
public class Steps extends Base{

	public WebDriver driver;
	public Registration reglogin;
	
	@Before
	public void setup() throws IOException {
		
		logger=Logger.getLogger("selenium-cucmber");//added logger
		PropertyConfigurator.configure("Log4j.properties");//added logger
		
		 configProp=new Properties();
		 FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
		String br=configProp.getProperty("browser");
	if (br.equals("chrome"))
		//System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));  
     	  ChromeOptions options = new ChromeOptions();
     	  options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
          options.addArguments("--remote-allow-origins=*");
       
     	  driver=new ChromeDriver(options);
		}
	else if (br.equals("firefox"))
		//System.setProperty("webdriver.gecko.driver", "C:\\driver\\firefoxdriver\\geckodriver.exe");
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("geckopath"));  
			FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
		}
	
	else if (br.equals("edge"))
		//System.setProperty("webdriver.edge.driver", "C:\\driver\\edgedriver\\msedgedriver.exe");
		{
		  System.setProperty("webdriver.edge.driver", configProp.getProperty("edgepath"));
    	//Instantiate a EdgeDriverclass:    
    	  EdgeOptions options = new EdgeOptions();
    	  options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
    	  options.addArguments("--remote-allow-origins=*");
    	           		 
    	  driver = new EdgeDriver(options);  
		}
	
     	  logger.info("******Launching browser*****");
		
	
	}
	
	@Given("I launch chrome browser")
	public WebDriver I_launch_chrome_browser() throws InterruptedException{
		
     	 reglogin = new Registration(driver);
     	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     	  driver.manage().window().maximize();
          Thread.sleep(5000);
          return driver;
          
		
	}
	
	@When("I open homepage url {string}")
	public void i_open_homepage_url(String url) {
		 logger.info("******Opening URL*****");
		driver.get(url);
	 	// driver.manage().window().maximize();
	 	// Thread.sleep(5000);
				
	}
	
	
	@And("I click on MyAccount button")
	public void I_click_on_MyAccount_button() {
		//driver.findElement(By.linkText("My Account")).click();
		
		 reglogin.ClickOnMyAccountButn();
	}
	
	@And("I entered username as {string} and email as {string} and password as {string} in registration form")
	public void enter_userdetails(String username, String email, String password) {
	//	driver.findElement(By.id("reg_username")).sendKeys("Admin111226");
	// 	 driver.findElement(By.id("reg_email")).sendKeys("pertest611621@gmail.com");
	 //	 driver.findElement(By.id("reg_password")).sendKeys("PERscholas$123");
	
		 logger.info("******providing user details*****");
		reglogin.EnterUserNameReg(username);
     reglogin.EnterEMailReg(email);
     reglogin.EnterPassReg(password);	 
	 	 
	}
	
	@And("I clicked on Register button")
	public void click_Register_button() throws InterruptedException {
		Actions action = new Actions(driver);
	 	 action.sendKeys(Keys.PAGE_DOWN).build().perform();
		//driver.findElement(By.name("register")).click();
	 	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	 	 logger.info("******clicked on register button*****");
	 	Thread.sleep(5000);
	 	reglogin.ClickOnRegBtn();
	}
	
	@Then("I validate My Account heading is displayed on page")
	public void validation() {
		//driver.findElement(By.className("entry-title")).getText();
		 
		reglogin.RegisterPageMess();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		WebElement elementAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("entry-title")));
		boolean status = elementAbout.isDisplayed();	
		
		Assert.assertEquals(true, status);
		logger.info("******expected msg seen*****");
	}
	
	@And("close chrome browser")
	public void close_browser() {
		driver.close();
		logger.info("******browser closed*****");
	}
}
