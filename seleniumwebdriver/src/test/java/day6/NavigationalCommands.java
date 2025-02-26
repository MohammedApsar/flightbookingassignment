package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {
	
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	
	driver.navigate().to("https://testautomationpractice.blogspot.com/");
	
	driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Java");

 }
}