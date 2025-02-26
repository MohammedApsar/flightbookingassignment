package day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new 	ChromeDriver();
		
		driver.get("https://demo.opencart.com/en-gb?route=common/home");
		driver.manage().window().maximize();
		
		boolean isLogoDisplayed = driver.findElement(By.id("logo")).isDisplayed();
		
		System.out.println(isLogoDisplayed);
		
		//driver.findElement(By.linkText("Desktops")).click();
		
		//driver.findElement(By.partialLinkText("Cam")).click();
		
		driver.getTitle();
		
		if(driver.getTitle().endsWith("Your Store")) {
			System.out.println("test case passed");
		}else {
			System.out.println("test case failed");
		}
		
		
		//List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//System.out.println(links.size());
		
		//List<WebElement> images = driver.findElements(By.tagName("img"));
		
		//System.out.println(images.size());
		
		//driver.findElement(By.cssSelector(null))
		
	
		//driver.findElement(By.cssSelector("input.form-control")).sendKeys("Apsar");
		
		driver.findElement(By.cssSelector("input[placeholder = 'Search']")).sendKeys("Apsar");
		
		driver.findElement(By.cssSelector("input.form-control.[placeholder='Search']"
				)).sendKeys("Apsar");
		
		

	}

}
