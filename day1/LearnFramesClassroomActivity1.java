package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFramesClassroomActivity1 {
	public static void main(String[] args) {
		
	
	
	WebDriverManager.chromedriver().setup();

	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
	driver.manage().window().maximize();
	
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.switchTo().frame("iframeResult");
	driver.findElement(By.xpath("//button[text() = 'Try it']")).click();
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.sendKeys("Hema");
	alert.accept();
		
	 WebElement element = driver.findElement(By.xpath("//p[@id ='demo']"));
	//WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Hema')])"));
	 System.out.println(element.getText());
	 
	}
}