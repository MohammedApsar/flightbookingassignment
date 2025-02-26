package day10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		
		//System.out.println("No of rows :" + rows);
		
		
		int column = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		
		/*System.out.println("No of  : column :"+ column);
		
		//read the specfic data from the from 5th row and table data 1 
		
		String apsar = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		
		System.out.println(apsar);*/
		
		//String saar = driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[3]")).getText();
		
		//System.out.println(saar);
		
		
		
		//read all the data from rows and columns
		
		/*for(int r= 2; r<=rows; r++){
			
			
			for(int c=1; c<=column; c++) {
				
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				
				System.out.print(value+"\t");
			}
			
			System.out.println();
		}*/
		
		
		//print the bookes names whos auther name is  mukesh 
		
		for(int r=2; r<= rows; r++) {
			
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(authorName.equals("Mukesh")) {
				
				String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				
				System.out.println(BookName);
			}
			
			
		}
		
		System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[6]")).getText());
		
		driver.quit();

	}

}
