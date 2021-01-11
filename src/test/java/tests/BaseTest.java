package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;

    JavascriptExecutor jse = (JavascriptExecutor) driver;{
        jse.executeScript("scroll(0, 250);");
    }
    JavascriptExecutor jseHomePage = (JavascriptExecutor) driver;{
        jseHomePage.executeScript("scroll(0, 250);");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void close() {
        //driver.quit();
    }
}
