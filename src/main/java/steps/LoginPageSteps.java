package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public class LoginPageSteps extends BaseSteps{
    Waiter wait;

    public LoginPageSteps(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }
    public void login(String key, String key2){
        wait.untilVisible(loginPage.enterToAccountLink).click();
        wait.untilVisible(loginPage.loginField).sendKeys(key);
        wait.untilVisible(loginPage.passwordField).sendKeys(key2);
        wait.untilVisible(loginPage.enterButton).click();
    }
}
