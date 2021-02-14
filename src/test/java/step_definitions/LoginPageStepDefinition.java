package step_definitions;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import waiters.Waiter;

public class LoginPageStepDefinition {

    private final BaseStepDefinition baseStepDefinition;


    public LoginPageStepDefinition(BaseStepDefinition baseStepDefinition) {
        this.baseStepDefinition = baseStepDefinition;
    }

    Waiter wait;
    protected static HomePage homePage;
    protected static LoginPage loginPage;


    @Given("user is on login page")
    public void openHomePageAndSwitchLanguage() {
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        homePage.openHomePage();
        wait.untilVisible(homePage.homePageAddMenu).click();
        wait.untilVisible(homePage.languageRuOrUa).click();
    }

    @When("user enters {string} and {string} field")
    public void login(String login, String password) {
        wait = new Waiter(baseStepDefinition.driver);
        loginPage = new LoginPage(baseStepDefinition.driver);
        wait.untilVisible(loginPage.enterToAccountLink);
        loginPage.enterToAccountLink.click();
        wait.untilVisible(loginPage.loginField).sendKeys(login);
        wait.untilVisible(loginPage.passwordField).sendKeys(password);
        wait.untilVisible(loginPage.enterButton).click();
    }

    @Then("user can see his name in account")
    public void checkNameOfAccount() {
        loginPage = new LoginPage(baseStepDefinition.driver);
        Assert.assertEquals(getUserText(), Constants.USER_NAME);
    }

    public String getUserText() {
        wait = new Waiter(baseStepDefinition.driver);
        loginPage = new LoginPage(baseStepDefinition.driver);
        wait.untilVisible(loginPage.userLink);
        return loginPage.userLink.getText();
    }
}
