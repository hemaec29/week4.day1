package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Step1: Load ServiceNow application URL
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev60992.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Step2: Enter username (Check for frame before entering the username)
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
				
		//Step3: Enter password
		driver.findElement(By.id("user_password")).sendKeys("rrCsEH96hHCr");
		//Step4: Click Login
		driver.findElement(By.id("sysverb_login")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Step5: Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident");
		
		//Step6: Click “All”
		driver.findElement(By.xpath("/html/body/div[5]/div/div/nav/div/div[3]/div/div/concourse-application-tree/ul/li[27]/ul/li[6]/div/div/a/div/div")).click();
		
		//Step7: Click New button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		//Step8: Select a value for Caller and Enter value for short_description
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windowHandles);
		
		String parentWindow = windowlist.get(0);
		String childWindow = windowlist.get(1);
		driver.switchTo().window(childWindow);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@class = 'form-control'])[1]")).sendKeys("Jade", Keys.ENTER);
		Thread.sleep(1000);
		WebElement findElement = driver.findElement(By.xpath("(//a[@class = 'glide_ref_item_link'])[1]"));
		//		wait.until(ExpectedConditions.visibilityOf(findElement));
		System.out.println(findElement.getText());
		findElement.click();
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Hello");
		WebElement incNum = driver.findElement(By.id("incident.number"));
		String incNumber = incNum.getAttribute("value");
		System.out.println(incNumber);
		driver.findElement(By.xpath("//button[@class = 'form_action_button  action_context btn btn-default']")).click();
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[@class = 'input-group']//following-sibling::input")).sendKeys(incNumber,Keys.ENTER);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File img = new File("./Screenshot/servicenow.jpg");
		FileUtils.copyFile(screenshotAs, img);
						/*Step9: Read the incident number and save it a variable
		Step10: Click on Submit button
		Step 11: Search the same incident number in the next search screen as below
		Step12: Verify the incident is created successful and take snapshot of the created incident.*/
		
	}

}
