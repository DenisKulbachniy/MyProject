package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ProductsPage;

public class SearchTest extends BaseTest {
    private static final String LAPTOP = "Ноутбук";
    public static final String FIND = "Найти";
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    @Test
    public void searchTest() {
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
        homePage.inputSearchField(LAPTOP);
        homePage.submitSearch();

        for (WebElement element : productsPage.getAllProductsName())
            Assert.assertTrue(element.getText().contains(LAPTOP));

        Assert.assertEquals(homePage.searchButtonFindAll.getText(), FIND);

        Assert.assertEquals(homePage.searchButtonFindBys.getText(), FIND);
    }

    @Test
    public void searchTestWithClear() {
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
        homePage.inputSearchField(LAPTOP);
        homePage.submitSearch();
        homePage.clearSearchFieldAfterInput();

        Assert.assertEquals(homePage.emptySearchField.getAttribute("class"), "search-form__input-wrapper");
    }
}