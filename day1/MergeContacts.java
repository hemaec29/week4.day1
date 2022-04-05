package week4.day1;

import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContacts {

	public static void main(String[] args) {
				
		WebDriverManager.chromedriver().setup();
		 
		 ChromeDriver driver = new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/login");
		 driver.manage().window().maximize();
				 
		 // 2. Enter UserName and Password Using Id Locator
		 driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		//* 3. Click on Login Button using Class Locator
		 driver.findElement(By.className("decorativeSubmit")).click();
		 // 4. Click on CRM/SFA Link
		 driver.findElement(By.linkText("CRM/SFA")).click();  
		 //5. Click on contacts Button
		 driver.findElement(By.linkText("Contacts")).click();
		 //6. Click on Merge Contacts using Xpath Locator
		 driver.findElement(By.linkText("Merge Contacts")).click();
		 ///* 7. Click on Widget of From Contact
		 driver.findElement(By.xpath("(//img[@ src='/images/fieldlookup.gif'])[1]")).click();
	 
		 		 
		 Set<String> windowHandles = driver.getWindowHandles();
	 
		 List<String> windows = new ArrayList<String>(windowHandles);
		 
		 String parentWindow = windows.get(0);
		 String fromContactWindow = windows.get(1);
		 System.out.println(fromContactWindow);
		 driver.switchTo().window(fromContactWindow);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("(//a[@class = 'linktext'])[1]")).click();
		 
		 driver.switchTo().window(parentWindow);
		 driver.findElement(By.xpath("(//img[@ src='/images/fieldlookup.gif'])[2]")).click();
		 
		 Set<String> windowHandles1 = driver.getWindowHandles();
		 
		 List<String> windows1 = new ArrayList<String>(windowHandles1);
		 
		 String parentWindow1 = windows1.get(0);
		 String toContactWindow = windows1.get(1);
		 System.out.println(toContactWindow);
		 driver.switchTo().window(toContactWindow);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("(//a[@class = 'linktext'])[1]")).click();
		 driver.switchTo().window(parentWindow1);
		 
		 driver.findElement(By.xpath("//a[@class = 'buttonDangerous']")).click();
		 
		 driver.switchTo().alert().accept();
		 
		 //print title of the page
		 WebElement mergeTitle =driver.findElement(By.xpath("//title[contains(text(),'Merge Contacts')]"));
		 System.out.println("Title is "+ driver.getTitle());
	}
		 
				 /*
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
	}


