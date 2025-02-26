package SmallProject;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class project {
    public static void main(String[] args) {
      
     WebDriver driver = new ChromeDriver();
     
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
     driver.get("https://blazedemo.com/");
     
     driver.manage().window().maximize();
     
     WebElement FirstDropdown= driver.findElement(By.name("fromPort"));
     Select FistSelectvalue = new Select (FirstDropdown);
     FistSelectvalue.selectByValue("Mexico City");
     
     WebElement SecondDropdown = driver.findElement(By.name("toPort"));
     Select SecondSelectvalue= new Select(SecondDropdown);
     SecondSelectvalue.selectByValue("New York");
     
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     
     List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));
     System.out.println("Total Number of rows:" + rows.size());
     
     List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table']//tbody//tr[1]//td"));
     System.out.println("Total Number of columns :" + columns.size());
     
     
     
     
     for(int r=1; r<=rows.size(); r++){
    	 
    	 for(int c=1; c<=columns.size(); c++) {
    		 
    		 WebElement Value = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]//td[ " + c +" ]"));
    		 
    		 System.out.print(Value.getText() + "\t");
    		 
    	 }
    	 
    	 System.out.println("");
     
     }
     
     
     List<WebElement> PriceColumn =driver.findElements(By.xpath("//table[@class='table']//tbody//tr//td[6]"));
     
     List<BigDecimal> Prices = new ArrayList<>();
     
     for(WebElement pr: PriceColumn) {
    	 
          String PriceValue = pr.getText().replace("$", "").trim();
          
          Prices.add(new BigDecimal(PriceValue));
     }
     
     Collections.sort(Prices);
     
     System.out.println(Prices);
     
     
     for(int i=0 ; i<=columns.size(); i++) {
    	 
    	 String PriceText = PriceColumn.get(i).getText().replace("$", "").trim();
    	 
    	 BigDecimal Price = new BigDecimal(PriceText);
    	 
    	 if(Price.compareTo(new BigDecimal("200.98")) <= 0) {
    		 
    		 driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + (i+1)+ "]//td[1]")).click();
    		 
    		 break;
    	 }
     }
    
     driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Apsar");
     
     driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Kphnb,543243");
     
     driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Hyderabad");
     
     driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Telangana");
     
     driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("543243");
     
     WebElement CardType =driver.findElement(By.xpath("//select[@id='cardType']"));
     
     
     Select CardTypeSelect = new Select(CardType);
     
     CardTypeSelect.selectByValue("amex");
     
     driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("5678 9234 4678 7651");
     
     WebElement Month =driver.findElement(By.xpath("//input[@id='creditCardMonth']"));
     
     Month.clear();
     
     Month.sendKeys("69");
     
     WebElement Year = driver.findElement(By.xpath("//input[@id='creditCardYear']"));
     
     Year.clear();
     
     Year.sendKeys("2029");
     
     driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Beeing Apsar");
     
     driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
     
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     
  
   }
}
