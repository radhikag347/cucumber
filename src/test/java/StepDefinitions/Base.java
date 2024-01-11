package StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pageobjects.Registration;

public class Base {
	
	public WebDriver driver;
	public Registration relogin;
	public static Logger logger;
    public Properties configProp;
	
	//random string generator
	public static String randomstring() {
		String genstring = RandomStringUtils.randomAlphabetic(5);
		return (genstring);
		
		
	}
	
	
	
	
}
