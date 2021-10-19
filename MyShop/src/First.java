import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class First {
	public static void main(String[] args) {  
		
		  System.setProperty("webdriver.chrome.driver",
		 "C:\\Users\\Goda\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  WebDriver driver= new ChromeDriver();
		  driver.get("https://editor.zyro.com/m7VVZ1J06zIaKO21/preview");
		  
		  // Close 'Accept cookies' window if it appears on screen
		  if (driver.findElements(By.xpath(
		  "//button[@data-qa='cookiesbanner-button-acceptall']")).size() != 0) {
		  driver.findElement(By.xpath(
		  "//button[@data-qa='cookiesbanner-button-acceptall']")).click();
		  }
		  
		  
		  // Need to login to zyro to be able to open created page. Enter login info
		  driver.findElement(By.xpath(
		  "//input[@data-qa='signin-inputfield-emailaddress']")).sendKeys(
		  "example@gmail.com");
		  driver.findElement(By.xpath("//input[@data-qa='signin-inputfield-password']")
		  ).sendKeys("example");
		  driver.findElement(By.xpath("//button[@data-qa='signin-btn-signin']")).click(
		  );
		  
		  
		  // From zyro user page we need to navigate to created website
		  new WebDriverWait(driver,
		  Duration.ofSeconds(90)).until(ExpectedConditions.elementToBeClickable(By.
		  xpath("//button[@data-qa='sites-btn-createnewwebsite']")));
		  driver.findElement(By.xpath(
		  "//button[@data-qa='sites-btn-editwebsite-null-feyer']")).click();
		  driver.findElement(By.xpath(
				  "//button[@data-qa='builder-header-btn-preview']")).click();
		  
		  // Now we can create test case for user flow
		  driver.findElement(By.xpath("//a[@href='/shop']")).click();
		  driver.findElement(By.xpath("//a[@text='Knitted Hat']")).click();
		  
		  // Add item to Favourites list
		  driver.findElement(By.xpath("//button[@aria-label='Save this product for later']")).click();
		  
		  // Go to Favourites list and from there add item to Shopping bag
		  driver.findElement(By.xpath("//button[@aria-label='View Favorites']")).click();
		  driver.findElement(By.xpath("//a[@title='Knitted Hat']")).click();
		  driver.findElement(By.xpath("//button[@title='form-control__button']")).click();
		  driver.findElement(By.xpath("//button[@title='Go to cart']")).click();
		  
		  // Verify item is on Shopping bag
		  if (driver.findElements(By.xpath("div[@class='ec-cart-item__wrap']//p[contains('Knitted Hat')]")).size() != 0) {
				System.out.println("Item was added to Shopping bag");
			} else {
				System.out.println("Item isn't added to Shopping bag");
			}
	}
}