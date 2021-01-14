package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogInTest extends BaseTest {

    private static final String INPUT_FOR_LOGIN = "petrovartem01061996@gmail.com";
    private static final String INPUT_FOR_PASSWORD = "01061996Artem";
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void logInToAcc() {
        homePage.openHomePage();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        loginPage.enterButtonClick();
        loginPage.enterToEnteredAccClick();
        loginPage.enterToEnteredAccClick();

        Assert.assertTrue(loginPage.getAccountName().contains(INPUT_FOR_LOGIN));
    }
}
