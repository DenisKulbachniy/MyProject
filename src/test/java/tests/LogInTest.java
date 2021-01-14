package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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
        WebElement element = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']"));
        Point point = element.getLocation();
        System.out.println("X cordinate : " + point.x + " Y cordinate: " + point.y);
        System.out.println(point.x);
        Assert.assertNotEquals(point.x,point.y);
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        System.out.println(loginPage.enterButtonSize());
        loginPage.enterButtonClick();
        loginPage.enterToEnteredAccClick();
        loginPage.enterToEnteredAccClick();

        Assert.assertTrue(loginPage.getAccountName().contains(INPUT_FOR_LOGIN));
    }
}
