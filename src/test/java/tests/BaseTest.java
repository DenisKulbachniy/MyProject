package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonnelAccountPage;
import pages.ProductsPage;
import steps.HomePageSteps;
import steps.LoginPageSteps;
import steps.PersonnelAccountSteps;
import steps.ProductsPageSteps;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static ProductsPage productsPage;
    protected static HomePageSteps homePageSteps;
    protected static LoginPageSteps loginPageSteps;
    protected static ProductsPageSteps productsPageSteps;
    protected static PersonnelAccountPage personnelAccountPage;
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
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        homePageSteps = new HomePageSteps(driver);
        loginPageSteps = new LoginPageSteps(driver);
        productsPageSteps = new ProductsPageSteps(driver);
        personnelAccountPage = new PersonnelAccountPage(driver);
        personnelAccountSteps = new PersonnelAccountSteps(driver);
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }
}
