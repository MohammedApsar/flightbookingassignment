package day8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlesFrame {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Apsar King");
		
		driver.switchTo().defaultContent();
		
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		
		driver.switchTo().frame(frame2);
		
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("mohammad King");
		
		driver.switchTo().defaultContent();
		
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("is these working");
		
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//div[@class='AB7Lab Id5V1']")).click();
		
		driver.switchTo().defaultContent();
		
		
		WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		
		driver.switchTo().frame(frame4);
		
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("this is the 4 test");
		
		driver.switchTo().defaultContent();
		
		
		
		//////////////
		
		WebElement Frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		
		driver.switchTo().frame(Frame5);
		
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("5th box test");
		
		
	
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//a[@href='https://a9t9.com/']")).click();
		
		driver.switchTo().defaultContent();
      
	}
}
