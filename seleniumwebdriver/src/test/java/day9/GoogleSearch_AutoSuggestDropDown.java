package day9;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch_AutoSuggestDropDown {
     
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.co.in/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		
		List <WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
		
		System.out.println(list.size());
		
		for(WebElement li : list) {
			
			System.out.println(li.getText());
			
			if(li.getText().equals("selenium")) {
				
				Thread.sleep(5000);
				li.click();
				break;
			}
		}
		
	
		
		
		
	}
}
