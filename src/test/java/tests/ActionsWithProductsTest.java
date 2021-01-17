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
    public static final String INLINE = "inline";
    public static final String emptyWishList = "У вас еще нет списков желаний";
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void productActionCartTest() {
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();

        Assert.assertEquals(homePage.productsCatalogue.getAttribute("class"), "menu-toggler");

        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.putFirstProductInCart();

        Assert.assertFalse(productsPage.isFirstProductSelected());

        productsPage.clickToHeaderCartButton();

        Assert.assertEquals(productsPage.getFirstProductName(), productsPage.getProductNameInCart());
        Assert.assertTrue(productsPage.isProductNameInCartEnabled());
        Assert.assertTrue(productsPage.isProductNameInCartDisplayed());
    }

    @Test
    public void productKitActionCartTest() {
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.clickToFirstProduct();
        jse.executeScript("scroll(0, 2500);");
        productsPage.buyKitClick();

        Assert.assertTrue(productsPage.getKitInCartText().contains(TOGETHER_CHEAP));
    }

    @Test
    public void productActionDeleteFromCartTest() {
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
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
        homePage.languageRuOrUa.get(0).click();
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        loginPage.enterButtonClick();
        homePage.navigateToCategoriesFromMainPage();

        String rozetkaImgDisplayCssValue = homePage.rozetkaImg.getCssValue("display");
        Assert.assertTrue(rozetkaImgDisplayCssValue.contains(INLINE));

        homePage.navigateToLaptopCategory();
        productsPage.clickToFirstProduct();
        productsPage.clickToProductTitle();
        productsPage.firstWishButtonClick();
        homePage.activeHeaderWishListButtonClick();

        Assert.assertTrue(productsPage.getProductNameInWishList().contains(LAPTOP));

        productsPage.addMenuInWishListClick();
        productsPage.deleteWishListClick();

        Assert.assertTrue(loginPage.getEmptyWishListText().contains(emptyWishList));
    }

    @Test
    public void wishListNewOwnListCreationTest() {
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
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

        Assert.assertTrue(loginPage.getEmptyWishListText().contains(emptyWishList));
    }

    @Test
    public void outOfStackProductTest() {
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
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

        Assert.assertTrue(loginPage.getEmptyWishListText().contains(emptyWishList));
    }

    @Test
    public void comparisonOfProductsTest() {
        homePage.openHomePage();
        homePage.languageRuOrUa.get(0).click();
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.comparisonButtonIsEnabled();
        productsPage.listOfComparisonProductsButtons().get(0).click();
        productsPage.listOfComparisonProductsButtons().get(1).click();
        homePage.activeHeaderComparisonButtonClick();
        homePage.comparisonListClick();

        for (WebElement element : productsPage.getAllProductsName()) {
            Assert.assertTrue(element.getText().contains(LAPTOP));
        }
    }
}
