package day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckAlerts {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		/*driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
		Thread.sleep(5000);
		
		Alert myAlert = driver.switchTo().alert();
		
		System.out.println(myAlert.getText());
		
		myAlert.accept();*/
		
		
		/*driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		
		Thread.sleep(1000);
		
		Alert myAlert = driver.switchTo().alert();
		
		System.out.println(myAlert.getText());
		
		myAlert.dismiss();*/
		
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		
		Thread.sleep(5000);
		
		Alert myAlert = driver.switchTo().alert();
		
		System.out.println(myAlert.getText());
		
		myAlert.sendKeys("Mohammed Apsar");
		
		myAlert.accept();
		
		
	}

}
