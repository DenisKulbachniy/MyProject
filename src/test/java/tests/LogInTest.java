package tests;

import constants.Constants;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogInTest extends BaseTest {

    @Test
    public void logInToAcc() {
        loginPageSteps.login(Constants.INPUT_FOR_LOGIN, Constants.INPUT_FOR_PASSWORD);

        for (WebElement element : personnelAccountPage.personnelData)
            Assert.assertEquals(element.getText(), (Constants.INPUT_FOR_LOGIN));
    }
}
