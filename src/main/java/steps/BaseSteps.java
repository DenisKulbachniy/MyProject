package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonnelAccountPage;
import pages.ProductsPage;
import waiters.Waiter;

public class BaseSteps {

    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    LoginPage loginPage;
    PersonnelAccountPage personnelAccountPage;
    Waiter wait;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        personnelAccountPage = new PersonnelAccountPage(driver);
        wait = new Waiter(driver);
    }
}
