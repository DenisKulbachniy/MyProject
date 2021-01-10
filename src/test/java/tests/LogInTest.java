package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogInTest extends BaseTest {

    @Test
    public void logInToAcc() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.openHomePage();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField();
        loginPage.inputPasswordField();
        loginPage.enterButtonClick();
    }

}
