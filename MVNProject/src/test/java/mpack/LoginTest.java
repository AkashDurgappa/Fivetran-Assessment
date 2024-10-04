package mpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
       
       driver = new ChromeDriver();
        
        driver.get("https://demo.guru99.com/test/login.html");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
       
        WebElement userField = driver.findElement(By.id("email"));
        
        WebElement passField = driver.findElement(By.id("passwd"));
        
        WebElement loginButton = driver.findElement(By.id("SubmitLogin"));

        
        userField.sendKeys(username);
        
        passField.sendKeys(password);

        loginButton.click();

    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        
        return new Object[][] {
           
        	{"user1@example.com", "password1"},
        	
            {"user2@example.com", "password2"}
        };
    }

    @AfterTest
    public void tearDown() {
        
        if (driver != null) {
            driver.quit();
        }
    }
}