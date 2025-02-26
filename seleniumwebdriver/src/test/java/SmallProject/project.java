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
      
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait time to 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Open the BlazeDemo website
        driver.get("https://blazedemo.com/");
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Select departure city from dropdown
        WebElement FirstDropdown = driver.findElement(By.name("fromPort"));
        Select FistSelectvalue = new Select(FirstDropdown);
        FistSelectvalue.selectByValue("Mexico City");
        
        // Select destination city from dropdown
        WebElement SecondDropdown = driver.findElement(By.name("toPort"));
        Select SecondSelectvalue = new Select(SecondDropdown);
        SecondSelectvalue.selectByValue("New York");
        
        // Click on the "Find Flights" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        // Get all rows in the flight selection table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));
        System.out.println("Total Number of rows: " + rows.size());
        
        // Get all columns in the first row of the table
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table']//tbody//tr[1]//td"));
        System.out.println("Total Number of columns: " + columns.size());
        
        // Iterate through the table and print each cell value
        for (int r = 1; r <= rows.size(); r++) {
            for (int c = 1; c <= columns.size(); c++) {
                WebElement Value = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]//td[" + c + "]"));
                System.out.print(Value.getText() + "\t");
            }
            System.out.println("");
        }
        
        // Extract flight prices from the table
        List<WebElement> PriceColumn = driver.findElements(By.xpath("//table[@class='table']//tbody//tr//td[6]"));
        List<BigDecimal> Prices = new ArrayList<>();
        
        // Convert price values to BigDecimal and add them to the list
        for (WebElement pr : PriceColumn) {
            String PriceValue = pr.getText().replace("$", "").trim();
            Prices.add(new BigDecimal(PriceValue));
        }
        
        // Sort the prices in ascending order
        Collections.sort(Prices);
        System.out.println(Prices);
        
        // Find and select the first available flight within the budget of $200.98
        for (int i = 0; i <= columns.size(); i++) {
            String PriceText = PriceColumn.get(i).getText().replace("$", "").trim();
            BigDecimal Price = new BigDecimal(PriceText);
            
            if (Price.compareTo(new BigDecimal("200.98")) <= 0) {
                driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + (i + 1) + "]//td[1]")).click();
                break;
            }
        }
        
        // Fill out the passenger details
        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Apsar");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Kphnb,543243");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Hyderabad");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Telangana");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("543243");
        
        // Select card type from dropdown
        WebElement CardType = driver.findElement(By.xpath("//select[@id='cardType']"));
        Select CardTypeSelect = new Select(CardType);
        CardTypeSelect.selectByValue("amex");
        
        // Enter credit card details
        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("5678 9234 4678 7651");
        
        // Clear and enter expiration month
        WebElement Month = driver.findElement(By.xpath("//input[@id='creditCardMonth']"));
        Month.clear();
        Month.sendKeys("69");
        
        // Clear and enter expiration year
        WebElement Year = driver.findElement(By.xpath("//input[@id='creditCardYear']"));
        Year.clear();
        Year.sendKeys("2029");
        
        // Enter name on card
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Beeing Apsar");
        
        // Click the "Remember Me" checkbox
        driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
        
        // Submit the purchase form
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
