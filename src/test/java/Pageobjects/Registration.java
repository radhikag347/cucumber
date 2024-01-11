package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Registration {
    WebDriver driver;

    // @FindBy(linkText = "My Account");
    //WebElement MyAccountButton;

    //By MyAccountButton = By.linkText("My Account");
    //By RegisterpageHeading = By.className("entry-title");
    
    //@FindBy: An annotation used in Page Factory to locate and declare web elements using different locators (id, name, Css, Xpath, TagName, Link).


    //@FindBy(linkText = "My Account")
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement MyAccountButton;
    
    @FindBy(id ="username")
    WebElement loginusername;
    
    @FindBy(id ="password")
    WebElement loginpwd;
    
    @FindBy (id = "reg_email")
    WebElement Reg_Email;

    @FindBy(id = "reg_password")
    WebElement Reg_Password;

    @FindBy(id ="reg_username")
    WebElement Reg_Username;

    @FindBy(name = "register")
    WebElement RegisterBtn;
    
    @FindBy(name = "login")
    WebElement LoginBtn;
    
   @FindBy(className = "woocommerce-error")
    WebElement ErrMsgUserName;

   @FindBy (className = "entry-title")
   WebElement RegisterpageHeading;
   
   @FindBy (xpath = "//div[@class='woocommerce-MyAccount-content']/p")
   WebElement LoginpageHeading;
   
//The initElements() method is used to initialize web elements. 
//   initElements() is a static method in Page Factory class. 
 //  Using the initElements method, one can initialize all the web elements located by @FindBy annotation.

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickOnMyAccountButn()
    {
        MyAccountButton.click();
    }
    public void EnterUserNameReg(String arg)
    {
        Reg_Username.sendKeys(arg);
    }
    public void EnterEMailReg(String arg)
    {
        Reg_Email.sendKeys(arg);
    }
    public void EnterPassReg(String arg)
    {
         Reg_Password.sendKeys(arg);
    }
    public void ClickOnRegBtn()
    {
        RegisterBtn.click();
    }
    
    public void entLoginusrnm(String arg)
    {
    	loginusername.sendKeys(arg);
    }
    
    public void entLoginusrpwd(String arg)
    {
    	loginpwd.sendKeys(arg);
    }
    
    public void ClickOnLoginBtn()
    {
    	LoginBtn.click();
    }

    public String RegisterPageMess()
    {
        return RegisterpageHeading.getText();
    }

    public String ErrorMsgUser()
    {
        return ErrMsgUserName.getText();
    }

    public String LoginPageMess()
    {
        return LoginpageHeading.getText();
    }

}
