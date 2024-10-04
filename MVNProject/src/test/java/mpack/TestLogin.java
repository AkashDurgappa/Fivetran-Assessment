package mpack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestLogin {
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKASH\\Downloads\\eclipse-jee-2024-03-R-win32-x86_64");

        
        WebDriver driver = new ChromeDriver();
        
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        try {
            
            String[] credentials = ExcelUtil.getCredentials("credentials.xlsx");
            String username = credentials[0];
            String password = credentials[1];
            
          
            driver.get("http://demo.guru99.com/V4/");
          
            WebElement usernameField = driver.findElement(By.name("uid"));
            usernameField.sendKeys(username);
            
            
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys(password);
           
            WebElement loginButton = driver.findElement(By.name("btnLogin"));
            loginButton.click();
            
           
            Alert alert = driver.switchTo().alert();
            alert.accept();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           
            driver.quit();
        }
    }
}
