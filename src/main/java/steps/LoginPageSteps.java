package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public class LoginPageSteps extends BaseSteps {
    Waiter wait;

    public LoginPageSteps(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String password) {
        wait.untilVisible(loginPage.enterToAccountLink).click();
        wait.untilVisible(loginPage.loginField).sendKeys(login);
        wait.untilVisible(loginPage.passwordField).sendKeys(password);
        wait.untilVisible(loginPage.enterButton).click();
    }

    public String getUserText() {
        wait.untilVisible(loginPage.userLink);
        return loginPage.userLink.getText();
    }
}
