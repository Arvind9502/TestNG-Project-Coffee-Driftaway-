package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class view_coffee {
	public static	WebDriver driver;
	@BeforeSuite
	 public void geturl() {
		 
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Desktop\\drivers\\gecko\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("https://driftaway.coffee");
			driver.manage().window().maximize();
			
	 }
	 @BeforeTest
	 	public void alert() {
		 	WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[11]/div/div")));
			System.out.println("Execution Of View Coffee Program Started");
			WebElement alert=driver.findElement(By.xpath("/html/body/div[11]/div/div"));
			System.out.println(alert.getText());
			WebElement close=driver.findElement(By.xpath("/html/body/div[11]/div/button"));
			close.click();		
	 }
  @Test
  public void a() throws InterruptedException {
	  	WebElement view=driver.findElement(By.linkText("VIEW COFFEES"));
		view.click();
		Thread.sleep(500);
  }
  @Test
  public void b() throws InterruptedException {
	  WebElement All=driver.findElement(By.xpath("//button[contains(text(),'SINGLE ORIGIN')]"));
		All.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		WebElement cold_brew=driver.findElement(By.xpath("//button[contains(text(),'COLD BREW')]"));
		cold_brew.click();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		WebElement decaf=driver.findElement(By.xpath("//button[contains(text(),'DECAF')]"));
		decaf.click();
		System.out.println(decaf.getText());
		js.executeScript("window.scrollBy(0,500)");
  }
  @AfterSuite public void close() {
	  System.out.println("Execution Of View Coffee program Sucessfully Complete");
	  driver.close();
  }
}
