package day3;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XPathdemo{
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.youtube.com/");
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("pavan qa");
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
	}
}
	