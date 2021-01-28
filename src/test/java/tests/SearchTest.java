package tests;

import constants.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {
        homePageSteps.fillInSearchFieldAndSubmit(Constants.LAPTOP);

        for (WebElement element : productsPage.allProductsNotFirstOnly)
            Assert.assertTrue(element.getText().contains(Constants.LAPTOP));
    }
}