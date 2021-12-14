package TestNG;

import java.security.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Help {
	public static WebDriver driver;
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
			System.out.println("Execution Of Help program Started");
			WebElement alert=driver.findElement(By.xpath("/html/body/div[11]/div/div"));
			System.out.println(alert.getText());
			WebElement close=driver.findElement(By.xpath("/html/body/div[11]/div/button"));
			close.click();
	 }
	 
	@Test
  public void a_Help() {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    List<WebElement> list =driver.findElements(By.xpath("//ul[@id='menu-footer-new-help']/li"));
		System.out.println("There are "+list.size()+ " options under SUSTAINABILITY");

	    for (WebElement element: list) {
	        System.out.println(element.getText());  
	    	}
	}
	@Test public void b_HelpCenter() throws InterruptedException {
	
	WebElement HelpCenter=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[4]/section/div/div/ul/li[1]/a"));
	HelpCenter.click();
	
	WebElement search=driver.findElement(By.xpath("//*[@id=\"hd-query\"]"));
	search.sendKeys("HOW DO I CANCEL MY ACCOUNT?"+Keys.ENTER);
	System.out.println(driver.getTitle());
	}
	
	@AfterSuite public void close() {
			System.out.println("Execution Of Help program Sucessfully Completed");
			driver.close();
	  }
	
}
