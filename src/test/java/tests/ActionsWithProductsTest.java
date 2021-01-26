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
    public static final String EMPTY_WISH_LIST = "У вас еще нет списков желаний";
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void productActionCartTest() {
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.visibilityOfCartButtons();
        productsPage.cartButton.get(0).click();
        productsPage.clickToHeaderCartButton();

        Assert.assertEquals(productsPage.productInCartFindAll.getText(), productsPage.getProductNameInCart());
        Assert.assertTrue(productsPage.isProductNameInCartEnabled());
        Assert.assertTrue(productsPage.isProductNameInCartDisplayed());
    }

    @Test
    public void productKitActionCartTest() {
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.productName.get(0).click();
        jse.executeScript("scroll(0, 2500);");
        productsPage.buyKitClick();

        Assert.assertTrue(productsPage.getKitInCartText().contains(TOGETHER_CHEAP));
    }

    @Test
    public void productActionDeleteFromCartTest() {
        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.fluentVisibilityOfCartButtons();
        productsPage.cartButton.get(0).click();
        productsPage.clickToHeaderCartButton();
        productsPage.addMenuForDeleteProductFromCartClick();
        productsPage.clickToDeleteInCartButton();

        Assert.assertTrue(productsPage.getEmptyCartText().contains(CART_IS_EMPTY));
    }

    @Test
    public void productActionWishListTest() {
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        loginPage.enterButtonClick();
        homePage.navigateToCategoriesFromMainPage();

        String rozetkaImgDisplayCssValue = homePage.rozetkaImg.getCssValue("display");
        Assert.assertEquals(rozetkaImgDisplayCssValue, INLINE);

        homePage.navigateToLaptopCategory();
        productsPage.visibilityOfProductsName();
        productsPage.productName.get(0).click();
        productsPage.clickToProductTitle();
        productsPage.wishButton.get(0).click();
        homePage.activeHeaderWishListButtonClick();

        Assert.assertTrue(productsPage.productName.get(0).getText().contains(LAPTOP));

        productsPage.addMenuInWishListClick();
        productsPage.deleteWishListClick();

        Assert.assertTrue(loginPage.getEmptyWishListText().contains(EMPTY_WISH_LIST));
    }

    @Test
    public void wishListNewOwnListCreationTest() {
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        loginPage.enterButtonClick();
        jseHomePage.executeScript("scroll(0, 250);");
        loginPage.accountWishListClick();
        loginPage.createNewWishListClick();
        loginPage.nameOfNewWishList(LAPTOPS);
        loginPage.addNewListOfWishesClick();

        Assert.assertTrue(loginPage.getNameOfWishList().contains(LAPTOPS));

        homePage.navigateToCategoriesFromMainPage();
        homePage.navigateToLaptopCategory();
        productsPage.visibilityOfProductsName();
        productsPage.productName.get(0).click();
        productsPage.clickToProductTitle();
        productsPage.wishButton.get(0).click();
        homePage.activeHeaderWishListButtonClick();

        Assert.assertTrue(productsPage.productName.get(0).getText().contains(LAPTOP));

        productsPage.addMenuInWishListClick();
        productsPage.deleteWishListClick();

        Assert.assertEquals(loginPage.getEmptyWishListText(), EMPTY_WISH_LIST);
    }

    @Test
    public void outOfStackProductTest() {
        loginPage.enterToAccountClick();
        loginPage.inputLoginField(INPUT_FOR_LOGIN);
        loginPage.inputPasswordField(INPUT_FOR_PASSWORD);
        loginPage.enterButtonClick();
        homePage.navigateToCategoriesFromMainPage();
        homePage.productForGamersCategoryClick();
        homePage.playstationCategoryClick();
        productsPage.playStationProductChoice.get(0).click();
        productsPage.clickToProductTitle();
        productsPage.notifyAboutAppearingOfProductButtonClick();
        homePage.activeHeaderWishListButtonClick();

        productsPage.visibilityOfProductsName();
        Assert.assertTrue(productsPage.productName.get(0).getText().contains(PLAYSTATION));

        productsPage.addMenuInWishListClick();
        productsPage.deleteWishListClick();

        Assert.assertTrue(loginPage.getEmptyWishListText().contains(EMPTY_WISH_LIST));
    }

    @Test
    public void comparisonOfProductsTest() {
        homePage.navigateToCategoriesFromMainPage();
        homePage.laptopsTextIsPresent();
        homePage.navigateToLaptopCategory();
        productsPage.visibilityOfComparisonProductsButtons();
        productsPage.comparisonOfProductsButtons.get(0).click();
        productsPage.comparisonOfProductsButtons.get(1).click();
        homePage.activeHeaderComparisonButtonClick();
        homePage.comparisonListClick();

        for (WebElement element : productsPage.allProductsNotFirstOnly) {
            Assert.assertTrue(element.getText().contains(LAPTOP));
        }
    }
}
