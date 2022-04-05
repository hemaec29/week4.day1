package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(01));

		WebElement searchElement = driver.findElement(By.id("twotabsearchtextbox"));
		searchElement.sendKeys("oneplus 9 pro", Keys.ENTER);
		String price = driver.findElement(By.xpath("(//span[@class ='a-price-whole'])[1]")).getText();
		System.out.println("The first appeared oneplus 9 pro price : " + price);
		// driver.findElement(By.xpath("(//span[@class ='a-icon-alt'])[1]

		// rating
		String customerRatingCount = driver
				.findElement(By.xpath(("(//span[@class = 'a-size-base s-underline-text'])[1]"))).getText();
		System.out.println("Total number of customers count : " + customerRatingCount);

		String ratingCount = driver.findElement(By.xpath(("(//span[@class = 'a-icon-alt'])[1]"))).getText();
		System.out.println("Total Rating : " + ratingCount);

		WebElement imagLink = driver
				.findElement(By.xpath(("(//div[@class= 'a-section aok-relative s-image-fixed-height'])[1]/img")));
		System.out.println("Image link text is :" + imagLink.getAttribute("src"));
		imagLink.click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windowList = new ArrayList<String>(windowHandles);

		String parentWindow = windowList.get(0);
		String childWindow = windowList.get(1);

		driver.switchTo().window(childWindow);
		System.out.println("You are in child window now");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(01));

		driver.findElement(By.id("add-to-cart-button")).click();
		System.out.println("Cart button clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(01));
		String cartSubTot = driver.findElement(By.xpath("//div[@class = 'a-column a-span11 a-text-left a-spacing-top-large']//span[2]/span")).getText();
		System.out.println("SubTotal of Cart : " + cartSubTot);
	
	
	}

}
