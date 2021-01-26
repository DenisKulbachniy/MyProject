package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;

    JavascriptExecutor jse = (JavascriptExecutor) driver;

    {
        jse.executeScript("scroll(0, 250);");
    }

    JavascriptExecutor jseHomePage = (JavascriptExecutor) driver;

    {
        jseHomePage.executeScript("scroll(0, 250);");
    }

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }
}
