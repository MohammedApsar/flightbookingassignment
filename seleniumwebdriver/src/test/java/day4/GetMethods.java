package day4;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	
	public static void main(String[]  args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/");
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.xpath("//a[@class='user-anonymous tnb-certificates-btn w3-bar-item w3-button w3-right w3-white ga-top ga-top-certificates']")).click();
		
	    Set <String> windowsId = driver.getWindowHandles();
	    
	    System.out.println(windowsId);
	    
	    driver.close();
	    
		
	}
	


}
