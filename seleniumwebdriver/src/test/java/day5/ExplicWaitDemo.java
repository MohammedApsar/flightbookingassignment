package day5;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicWaitDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        // Click a link that opens a new window
        driver.findElement(By.linkText("Link Text")).click(); // Replace with actual link text

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        String mainWindowHandle = driver.getWindowHandle();

        // Switch to the new window and close it
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.close();
            }
        }

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        driver.quit();
    }
}

   