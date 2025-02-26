package day9;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

	public static void main(String[] args) {
		
	 WebDriver driver = new ChromeDriver();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	 
	 driver.manage().window().maximize();
	 
	 driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
	 
	 driver.findElement(By.xpath("//input[@value='Java']")).click();
	 
	 
	 List<WebElement> Options= driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
	 
	 System.out.println("Number of options = " + Options.size());
	 
	 
	 /*for(int i=0 ;i <Options.size(); i++) {
		
		 System.out.println(Options.get(i).getText());
	 }*/
	 
	 
	 for(WebElement op:Options){
		
		 String option=op.getText();
		 
		 if(option.equals("MySQL") || option.equals("C#") || option.equals("Python")){
			 
			 op.click();
		 }
	}
  }
}
