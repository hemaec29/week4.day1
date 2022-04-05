package week4.day1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherFrames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(01));
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id ='topic']//following-sibling::input")).sendKeys("Hi Hema");
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		WebElement animalDropdown = driver.findElement(By.id("animals"));
		Select dd = new Select(animalDropdown);
		dd.selectByVisibleText("Big Baby Cat");
		
		driver.close();
	
	}

}
