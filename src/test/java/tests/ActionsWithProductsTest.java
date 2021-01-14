package tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class ActionsWithProductsTest extends BaseTest {
    private static final String INPUT_FOR_LOGIN = "Petrovartem01061996@gmail.com";
    private static final String INPUT_FOR_PASSWORD = "01061996Artem";
    private static final String LAPTOP = "Ноутбук";
    private static final String LAPTOPS = "Ноутбуки";
    private static final String TOGETHER_CHEAP = "Вместе дешевле";
    private static final String CART_IS_EMPTY = "Корзина пуста";
    private static final String PLAYSTATION = "PlayStation";
    private static final String NULL = null;
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void productActionCartTest() {
        homePage.openHomePage();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.putFirstProductInCart();

        Assert.assertFalse(productsPage.putFirstProductInCartIsSelected());

        productsPage.clickToHeaderCartButton();

        Assert.assertEquals(productsPage.getFirstProductName(), productsPage.getProductNameInCart());
        Assert.assertTrue(productsPage.getProductNameInCartIsEnabled());
        Assert.assertTrue(productsPage.getProductNameInCartIsDisplayed());
    }

    @Test
    public void productKitActionCartTest() {
        homePage.openHomePage();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.clickToFirstProduct();
        jse.executeScript("scroll(0, 2500);");
        productsPage.buyKitClick();

        Assert.assertTrue(productsPage.getKitInCartText().contains(TOGETHER_CHEAP));
        Assert.assertEquals(productsPage.getKitInCartAttribute(), NULL);
    }

    @Test
    public void productActionDeleteFromCartTest() {
        homePage.openHomePage();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.putFirstProductInCart();
        productsPage.clickToHeaderCartButton();
        productsPage.addMenuForDeleteProductFromCartClick();
        productsPage.clickToDeleteInCartButton();

        Assert.assertTrue(productsPage.getEmptyCartText().contains(CART_IS_EMPTY));
    }

    @Test
    public void productActionWishListTest() {
        homePage.openHomePage();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        loginPage.enterButtonClick();
        homePage.navigateToCategoriesFromMainPage();
        System.out.println(homePage.navigateToLaptopCategory11111());
        Assert.assertTrue(homePage.navigateToLaptopCategory11111());
        homePage.navigateToLaptopCategory();
        productsPage.clickToFirstProduct();
        productsPage.clickToProductTitle();
        productsPage.firstWishButtonClick();
        homePage.activeHeaderWishListButtonClick();

        Assert.assertTrue(productsPage.getProductNameInWishList().contains(LAPTOP));

        productsPage.addMenuInWishListClick();
        productsPage.deleteWishListClick();
    }

    @Test
    public void wishListNewOwnListCreationTest() {
        homePage.openHomePage();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        loginPage.enterButtonClick();
        jseHomePage.executeScript("scroll(0, 250);");
        loginPage.accountWishListClick();
        loginPage.createNewWishListClick();
        loginPage.nameOfNewWishList();
        loginPage.addNewListOfWishesClick();

        Assert.assertTrue(loginPage.getNameOfWishList().contains(LAPTOPS));

        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.clickToFirstProduct();
        productsPage.clickToProductTitle();
        productsPage.firstWishButtonClick();
        homePage.activeHeaderWishListButtonClick();

        Assert.assertTrue(productsPage.getProductNameInWishList().contains(LAPTOP));

        productsPage.addMenuInWishListClick();
        productsPage.deleteWishListClick();
    }

    @Test
    public void outOfStackProductTest() {
        homePage.openHomePage();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        loginPage.enterButtonClick();
        homePage.navigateToCategoriesFromMainPage();
        homePage.productForGamersCategoryClick();
        homePage.playstationCategoryClick();
        productsPage.playStationChoiceClick();
        productsPage.clickToProductTitle();
        productsPage.notifyAboutAppearingOfProductButtonClick();
        homePage.activeHeaderWishListButtonClick();

        Assert.assertTrue(productsPage.getProductNameInWishList().contains(PLAYSTATION));

        productsPage.addMenuInWishListClick();
        productsPage.deleteWishListClick();
    }

    @Test
    public void comparisonOfProductsTest() {
        homePage.openHomePage();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.clickToCompareFirstProduct();
        productsPage.clickToCompareSecondProduct();
        homePage.activeHeaderComparisonButtonClick();
        homePage.comparisonListClick();

        for (WebElement element : productsPage.getAllProductsName()) {
            Assert.assertTrue(element.getText().contains(LAPTOP));
        }
    }
}
