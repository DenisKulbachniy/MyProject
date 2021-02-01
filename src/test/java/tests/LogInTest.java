package tests;

import constants.Constants;
import org.junit.Test;
import org.testng.Assert;

public class LogInTest extends BaseTest {

    @Test
    public void logInToAcc() {
        loginPageSteps.login(Constants.INPUT_FOR_LOGIN, Constants.INPUT_FOR_PASSWORD);

        Assert.assertEquals(loginPageSteps.getUserText(), Constants.USER_NAME);
    }
}
