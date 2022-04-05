package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		//driver.switchTo().alert();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		 
		 List<String> windows = new ArrayList<String>(windowHandles);
		 
		 String parentWindow = windows.get(0);
		 String flightWindow = windows.get(1);
		 driver.switchTo().window(flightWindow);
		 System.out.println("You are in Flight window");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (200));
		 wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//button [@class ='izooto-optin--cta izooto-optin--cta-later']"))));
		 driver.findElement(By.xpath("//button [@class ='izooto-optin--cta izooto-optin--cta-later']")).click();
		
//Print the customer care email id
			driver.findElement(By.xpath("//a [text() = 'Contact Us']")).click();
			String email = driver.findElement((By.xpath("//a [contains (text() , '@irctc.co.in')]" ))).getText();
			System.out.println("The Customer care email id is : " +email);
		 driver.close();
		 
		 
		

	}

}
