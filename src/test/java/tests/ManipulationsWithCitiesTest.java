package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;

public class ManipulationsWithCitiesTest extends BaseTest{

    @Test
    public void tryToChangeCityTest(){
        HomePage homePage = new HomePage(getDriver());

        homePage.openHomePage();
        homePage.chooseCityClick();
        homePage.chooseCityFromListOfCitiesClick();
        homePage.acceptButtonToChooseCityClick();
        Assert.assertTrue(homePage.chooseCityGetText().contains("Киев"));
    }

}
