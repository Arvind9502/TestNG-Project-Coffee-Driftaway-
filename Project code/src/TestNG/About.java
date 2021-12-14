package TestNG;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class About {
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
			System.out.println("Execution Of About Program Started");
			WebElement alert=driver.findElement(By.xpath("/html/body/div[11]/div/div"));
			System.out.println(alert.getText());
			WebElement close=driver.findElement(By.xpath("/html/body/div[11]/div/button"));
			close.click();
	 }
	 
  @Test
  public void a_About() {

		//*************Get Options Under ABOUT and Check one of them**************
		WebElement about=driver.findElement(By.xpath("//ul[@id='menu-footer-new-about']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",about);
		List<WebElement> list =driver.findElements(By.xpath("//ul[@id='menu-footer-new-about']/li"));
		System.out.println("There are "+list.size()+" options under ABOUT");

	    for (WebElement element: list) {
	        System.out.println(element.getText());  
	    	}
  	}
  @Test
  public void b_AboutUs() throws InterruptedException {
	  //click each one start with **************ABOUT US***************
	    WebElement about_us=driver.findElement(By.xpath("//a[contains(text(),'About us')]"));
	    about_us.click();
	    System.out.println(driver.getTitle());
	    Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  

  }
  @Test
  public void c_OurStory() {
	  //****************access OUR STORY*****************
	    
	    WebElement our_story=driver.findElement(By.xpath("//a[contains(text(),'Our Story')]"));
	    our_story.click();
	    System.out.println(driver.getTitle());
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
  }
  @Test
  public void e_CoffeeCadmy() {
	  //access COFFEE CADEMY
	    WebElement academy=driver.findElement(By.linkText("Coffeecademy"));
	    academy.click();
		System.out.println(driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }
  
  @Test
  public void f_AccessReviews() throws InterruptedException {
	//access reviews 
			WebElement reviews=driver.findElement(By.linkText("Reviews"));
			reviews.click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }
  
  @Test
  public void g_PressKit() throws InterruptedException, IOException {
	//access press kit
			WebElement presskit=driver.findElement(By.linkText("Press Kit"));
			presskit.click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			TakesScreenshot ss=(TakesScreenshot)driver;
			File src=ss.getScreenshotAs(OutputType.FILE);
			Files.copy(src,new File("C:\\Users\\admin\\Desktop\\selenium\\ss.png"));		
  }
  
  @AfterSuite public void close() {
	 System.out.println("Execution Of About Is Sucessfully Completed");
	  driver.close();
  }
}
  
  
  
  
