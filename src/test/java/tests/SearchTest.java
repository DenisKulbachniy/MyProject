package tests;

import constants.Constants;
import org.junit.Assert;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {
        homePageSteps.fillInSearchFieldAndSubmit(Constants.LAPTOP);

        Assert.assertEquals(productsPageSteps.getHeaderProductsText(),Constants.LAPTOPS);
    }
}