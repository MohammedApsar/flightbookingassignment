package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlesCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		List<WebElement> Checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		
		
		for(int i=0; i<3; i++){
			
			Checkboxes.get(i).click();
			
		}
		
		Thread.sleep(5000);
		
		for(int i=0;i<3;i++) {
			
			Checkboxes.get(i).click();
			
		}
		
		
	}
}
