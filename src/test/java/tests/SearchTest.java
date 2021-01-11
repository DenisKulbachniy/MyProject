package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.ProductsPage;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.openHomePage();
        homePage.inputSearchField();
        homePage.searchButtonClick();
        Assert.assertTrue(productsPage.getAllProductsName().contains("Ноутбук"));


    }
}