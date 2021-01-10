package tests;

import org.junit.Test;
import pages.HomePage;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {
        HomePage homePage = new HomePage(getDriver());

        homePage.openHomePage();
        homePage.inputSearchField();
        homePage.searchButtonClick();


    }
}