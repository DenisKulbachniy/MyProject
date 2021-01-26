package tests;

import models.User;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginPage;

public class LogInTest extends BaseTest {
    private static final String INPUT_FOR_LOGIN = "petrovartem01061996@gmail.com";
    private static final String INPUT_FOR_PASSWORD = "01061996Artem";
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void logInToAcc() {
        User user = new User(INPUT_FOR_LOGIN, INPUT_FOR_PASSWORD);
        loginPage.login(user);
        loginPage.goToAccountPage();

        for (WebElement element : loginPage.personnelData)
            Assert.assertEquals(element.getText(), (INPUT_FOR_LOGIN));
    }
}
