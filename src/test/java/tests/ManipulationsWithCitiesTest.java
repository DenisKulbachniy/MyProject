package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;

public class ManipulationsWithCitiesTest extends BaseTest {
    private static final String KIEV = "Киев";
    HomePage homePage = new HomePage(getDriver());

    @Test
    public void tryToChangeCityTest() {
        homePage.openHomePage();
        homePage.chooseCityClick();
        homePage.chooseCityFromListOfCitiesClick();
        homePage.acceptButtonToChooseCityClick();

        Assert.assertTrue(homePage.chooseCityGetText().contains(KIEV));
    }
}
