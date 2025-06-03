package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class StockUpdateTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://example-inventoryapp.com");
    }

    @Test
    public void testStockUpdate() {
        driver.findElement(By.id("adminLogin")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.id("loginBtn")).click();

        driver.findElement(By.linkText("Inventory")).click();
        driver.findElement(By.cssSelector(".edit-stock")).click();
        driver.findElement(By.name("stockCount")).clear();
        driver.findElement(By.name("stockCount")).sendKeys("150");
        driver.findElement(By.id("saveBtn")).click();

        String message = driver.findElement(By.id("message")).getText();
        assert message.contains("updated successfully");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
