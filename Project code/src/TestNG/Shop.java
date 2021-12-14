package TestNG;

import java.util.Iterator;
import java.util.List;

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

public class Shop {
  
	public static WebDriver driver;
	//Call function for scrolling down
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}	
	
	
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
			System.out.println("Execution Of Shop Program Started");
			WebElement alert=driver.findElement(By.xpath("/html/body/div[11]/div/div"));
			System.out.println(alert.getText());
			WebElement close=driver.findElement(By.xpath("/html/body/div[11]/div/button"));
			close.click();
	 }
	 
	 
	 @Test public void a_getlist() {
		//Get list of options under Shop
			scroll();
		    List<WebElement> list =driver.findElements(By.xpath("//ul[@id='menu-footer-new-shop-for-you']/li"));
			System.out.println("There are "+list.size() + " options under Shop");

		    for (WebElement element: list) {
		        System.out.println(element.getText());  
		    	}
		    }
	@Test
	  public void b_Subscription() throws InterruptedException {
			WebElement subcription=driver.findElement(By.linkText("Subscriptions"));
			subcription.click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			scroll();
	  }
	@Test
	  public void c_SingleBags() throws InterruptedException {
			WebElement singlebag=driver.findElement(By.linkText("Single bags"));
			singlebag.click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			scroll();
	  }
	@Test
	  public void d_ColdBrew() throws InterruptedException {
			WebElement Coldbrew=driver.findElement(By.linkText("Cold brew"));
			Coldbrew.click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			scroll();
	  }
	@Test
	  public void e_CoffeeGear() throws InterruptedException {
			WebElement Coffeegear=driver.findElement(By.linkText("Coffee gear"));
			Coffeegear.click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			scroll();
	  }
	  @Test
	  public void f_VirtualTest() throws InterruptedException {
			WebElement VirtualTest=driver.findElement(By.linkText("Virtual Tasting Parties"));
			VirtualTest.click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			scroll();
	  }
	  
	 // Explorer kits
	  @Test
	  public void g_ExplorerKit() throws InterruptedException {
			WebElement ExplorerKits=driver.findElement(By.linkText("Explorer kits"));
			ExplorerKits.click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
	  }
	  
	  @AfterSuite public void close() {
		  System.out.println("Execution Of Shop program Sucessfully Complete");
		  driver.close();
	  }
	  
	  
}
