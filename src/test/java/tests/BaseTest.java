package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.HomePageSteps;
import steps.LoginPageSteps;
import steps.PersonnelAccountSteps;
import steps.ProductsPageSteps;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePageSteps homePageSteps;
    protected static LoginPageSteps loginPageSteps;
    protected static ProductsPageSteps productsPageSteps;
    protected static PersonnelAccountSteps personnelAccountSteps;


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
        homePageSteps = new HomePageSteps(driver);
        loginPageSteps = new LoginPageSteps(driver);
        productsPageSteps = new ProductsPageSteps(driver);
        personnelAccountSteps = new PersonnelAccountSteps(driver);
        homePageSteps.openHomePageAndSwitchLanguage();
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }
}
