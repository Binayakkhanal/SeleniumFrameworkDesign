package Company.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Company.AbstractComponents.AbstractedComponent;

public class LandingPage extends AbstractedComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) //Constructor
	{
		super(driver);
		//initialization 
		this.driver = driver; // this.driver refers to local class while = driver is from arguments. Similarly, = driver has only scope inside this constructor or methods
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
	}

}
