package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ProductsPage;

public class SearchTest extends BaseTest {
    private static final String LAPTOP = "Ноутбук";
    HomePage homePage = new HomePage(getDriver());
    ProductsPage productsPage = new ProductsPage(getDriver());

    @Test
    public void searchTest() {
        homePage.openHomePage();
        homePage.inputSearchField();
        homePage.searchButtonClick();

        for (WebElement element : productsPage.getAllProductsName())
            Assert.assertTrue(element.getText().contains(LAPTOP));
    }
}