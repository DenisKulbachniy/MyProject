package tests;

import org.junit.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class ActionsWithProductsTest extends BaseTest {

    @Test
    public void productActionCartTest() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.openHomePage();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.putFirstProductInCart();
        productsPage.clickToHeaderCartButton();
        Assert.assertEquals(productsPage.getFirstProductName(), productsPage.getProductNameInCart());
    }

    @Test
    public void productKitActionCartTest() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.openHomePage();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.clickToFirstProduct();
        jse.executeScript("scroll(0, 2500);");
        productsPage.buyKitClick();
        Assert.assertTrue(productsPage.getKitInCartText().contains("Вместе дешевле"));
    }

    @Test
    public void productActionDeleteFromCartTest() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.openHomePage();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.putFirstProductInCart();
        productsPage.clickToHeaderCartButton();
        productsPage.addMenuForDeleteProductFromCartClick();
        productsPage.clickToDeleteInCartButton();
        Assert.assertTrue(productsPage.getEmptyCartText().contains("Корзина пуста"));
    }

    @Test
    public void productActionWishListTest() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.openHomePage();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField();
        loginPage.inputPasswordField();
        loginPage.enterButtonClick();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.clickToFirstProduct();
        productsPage.clickToProductTitle();
        productsPage.firstWishButtonClick();
        homePage.ActiveHeaderWishListButtonClick();
        Assert.assertTrue(productsPage.getProductNameInWishList().contains("Ноутбук"));
    }

    @Test
    public void wishListNewOwnListCreationTest() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.openHomePage();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField();
        loginPage.inputPasswordField();
        loginPage.enterButtonClick();
        jseHomePage.executeScript("scroll(0, 250);");
        loginPage.accountWishListClick();
        loginPage.createNewWishListClick();
        loginPage.nameOfNewWishList();
        loginPage.addNewListOfWishesClick();
        Assert.assertTrue(loginPage.getNameOfWishList().contains("Ноутбуки"));
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.clickToFirstProduct();
        productsPage.clickToProductTitle();
        productsPage.firstWishButtonClick();
        homePage.ActiveHeaderWishListButtonClick();
        Assert.assertTrue(productsPage.getProductNameInWishList().contains("Ноутбук"));


    }

    @Test
    public void outOfStackProductTest() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.openHomePage();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField();
        loginPage.inputPasswordField();
        loginPage.enterButtonClick();
        homePage.navigateToCategoriesFromMainPage();
        homePage.ProductForGamersCategoryClick();
        homePage.playstationCategoryClick();
        productsPage.playStationChoiceClick();
        productsPage.clickToProductTitle();
        productsPage.notifyAboutAppearingOfProductButtonClick();
        homePage.ActiveHeaderWishListButtonClick();
        Assert.assertTrue(productsPage.getProductNameInWishList().contains("PlayStation"));
    }

    @Test
    public void comparisonOfProductsTest() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.openHomePage();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.clickToCompareFirstProduct();
        productsPage.clickToCompareSecondProduct();
        homePage.ActiveHeaderComparisonButtonClick();
        homePage.comparisonListClick();
        Assert.assertTrue(productsPage.getFirstProductName().contains("Ноутбук"));
        Assert.assertTrue(productsPage.getSecondProductName().contains("Ноутбук"));


    }
}
