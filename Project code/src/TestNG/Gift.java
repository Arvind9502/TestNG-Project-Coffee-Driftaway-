package TestNG;

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

public class Gift {
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
			System.out.println("Execution Of Gift program Started");
			WebElement alert=driver.findElement(By.xpath("/html/body/div[11]/div/div"));
			System.out.println(alert.getText());
			WebElement close=driver.findElement(By.xpath("/html/body/div[11]/div/button"));
			close.click();
	 }
	 
	 
	 @Test public void a_getlist() {
		//Get list of options under Gifts
		 	scroll();
		    List<WebElement> list =driver.findElements(By.xpath("//ul[@id='menu-footer-new-shop-gifts']/li"));
			System.out.println("There are "+list.size()+" options under Gifts");

		    for (WebElement element: list) {
		        System.out.println(element.getText());  
		    	}
	 }
	
	
	@Test public void b_subscription() {
		WebElement subscription=driver.findElement(By.linkText("Subscriptions"));
		subscription.click();
		System.out.println(driver.getTitle());
		scroll();
	}
	
	@Test public void c_SingleBag() {
		WebElement singlebag=driver.findElement(By.linkText("Single bags"));
		singlebag.click();
		System.out.println(driver.getTitle());
		scroll();
	}
	@Test public void d_Virtual() {
		WebElement virtual=driver.findElement(By.linkText("Virtual Tasting Parties"));
		virtual.click();
		System.out.println(driver.getTitle());
		scroll();
	}
	
	@Test public void e_ExplorerKit() {
		WebElement ExplorerKit=driver.findElement(By.linkText("Explorer kits"));
		ExplorerKit.click();
		System.out.println(driver.getTitle());
		scroll();
	}
	@Test public void f_recieved() {
		WebElement recieved=driver.findElement(By.linkText("Received a Gift Subscription?"));
		recieved.click();
		System.out.println(driver.getTitle());
	}
	@AfterSuite public void close() {
			System.out.println("Execution Of Gift program Sucessfully Completed");
		  driver.close();
	  }
  
  
}
