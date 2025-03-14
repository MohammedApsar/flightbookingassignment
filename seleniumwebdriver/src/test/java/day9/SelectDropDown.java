package day9;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
	
	public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://testautomationpractice.blogspot.com/");
	
	driver.manage().window().maximize();
	
	WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country']"));
	
	Select drpCountry = new Select(drpCountryEle);
	
	
	
	//drpCountry.selectByValue("japan");
	
	//drpCountry.selectByVisibleText("India");
	
	//drpCountry.selectByIndex(7);
	
	 List<WebElement> Opitions= drpCountry.getOptions();
	 
	 System.out.println("the total options = "+ Opitions.size());
	 
	 /*for(int i=0; i < Opitions.size(); i++) {
		 
		 System.out.println(Opitions.get(i).getText());
		 
	 }*/
	 
	 
	 for(WebElement op : Opitions){
		 
		 System.out.println(op.getText());
	 }
	 
	 
	 
	 
	
	}
}
