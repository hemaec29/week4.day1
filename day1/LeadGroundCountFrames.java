package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadGroundCountFrames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		
		List<WebElement> countFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("No of frames in Leafground is "+countFrames.size());
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		
		//nested frame
		driver.switchTo().frame(1);
		driver.switchTo().frame(driver.findElement(By.id("frame2")));
		driver.findElement(By.id("Click1")).click();
		
		driver.quit();
		
		}
	
}
