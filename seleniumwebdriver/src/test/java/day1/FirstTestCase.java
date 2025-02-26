package day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;


public class FirstTestCase {
 
	public static void main(String[] args) {
		
		//ChromeDriver driver = new ChromeDriver();
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.javatpoint.com/selenium-webdriver-commands");
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if(title.equals("WebDriver Commands")) {
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed");
		}
		
		driver.quit();
	}
}
