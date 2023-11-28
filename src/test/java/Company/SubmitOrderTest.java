package Company;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Company.pageobjects.CartPage;
import Company.pageobjects.CheckoutPage;
import Company.pageobjects.ConfirmationPage;
import Company.pageobjects.LandingPage;
import Company.pageobjects.ProductCatalogue;

import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

// Page Object Model

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("Ramthapa@gmail.com", "Asd@1234");
			
		List<WebElement> products = productCatalogue.getProductList();
		
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(productName);

		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		checkoutPage.submitOrder();
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.close();

	}

}


//ProductCatalogue productCatalogue = new ProductCatalogue(driver);

//CartPage cartPage = new CartPage(driver);

//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//
//WebElement prod = products.stream().filter(product->
//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);


//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
////ng-animating
//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

//WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
//WebElement cartButton = wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
//JavascriptExecutor executor = (JavascriptExecutor) driver;
//executor.executeScript("arguments[0].click();", cartButton);

//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));

//driver.findElement(By.cssSelector(".totalRow button")).click();
//
//Actions a = new Actions(driver);
//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//
//
//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//driver.findElement(By.cssSelector(".action__submit")).click();

//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));