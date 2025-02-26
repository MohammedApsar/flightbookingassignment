package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionMethods {
	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
        driver.manage().window().maximize();
        
        System.out.println(driver.findElement(By.xpath("//h1[text()='Register']")).isDisplayed());
		
        System.out.println(driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed());
		
        System.out.println(driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());
        
        System.out.println(driver.findElement(By.xpath("//input[@class='search-box-text ui-autocomplete-input']")).isEnabled());
	
        System.out.println(driver.findElement(By.xpath("//button[@id='register-button']")).isEnabled());
  
	
	    
	}
	
	
	
	
	

}
