package week4.day1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlets {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		System.out.println(alert.getText());
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("Hema G");
		alert3.accept();
		
		

	}

}
