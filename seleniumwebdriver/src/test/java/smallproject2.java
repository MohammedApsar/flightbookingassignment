package smallproject2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assigment {
	
	public static void main(String[] args) throws InterruptedException {
             
		// Initialize WebDriver for Chrome browser
		WebDriver driver = new ChromeDriver();
		
		// Set an implicit wait of 10 seconds for all elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Open the target webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		
        // Maximize the browser window
		driver.manage().window().maximize();
	    
		// Find all pagination elements (list items <li> under pagination <ul>)
		List <WebElement> no_of_pages = driver.findElements(By.xpath("//ul[@class='pagination']//li"));
		
		// Print the total number of pages
		System.out.println(no_of_pages.size());
		
		// Loop through each page in the pagination
		for(int i=1; i <= no_of_pages.size(); i++) {
		
			// Locate and click on the pagination link corresponding to page 'i'
			WebElement pages = driver.findElement(By.xpath("//ul[@id='pagination']//a[text()= "+ i +" ]"));
			pages.click();
		  
			// Wait for 2 seconds to allow page data to load (not the best practice; use WebDriverWait instead)
			Thread.sleep(2000);
		  
			// Count the number of rows in the product table
			int no_of_rows =  driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		  
			// Iterate through each row in the table
			for(int r=1; r<= no_of_rows; r++) {
				// Extract the product name from the second column
				String Name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
				
				// Extract the product price from the third column
				String Price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]")).getText();
				
				// Locate and click the checkbox in the fourth column
				WebElement Checkbox = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[4]//input[@type='checkbox']"));
				Checkbox.click();
				
				// Print the extracted product name and price
				System.out.println(Name + "\t" + Price + "\t");
			}
		}
		
		// Close the browser after execution
		driver.quit();
	}
}

