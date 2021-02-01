package tests;

import constants.Constants;
import org.junit.Assert;
import org.junit.Test;

public class ManipulationsWithCitiesTest extends BaseTest {

    @Test
    public void tryToChangeCityTest() {
        homePageSteps.changeCity();

        Assert.assertTrue(homePageSteps.getChooseCityText().contains(Constants.KIEV));
    }
}
