package tests;

import constants.Constants;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ActionsWithProductsTest extends BaseTest {

    @Test
    public void productActionCartTest() {
        homePageSteps.navigateToLaptopCategory();
        productsPageSteps.addProductInCart();
        homePageSteps.navigateToProductCart();

        Assert.assertEquals(productsPage.productInCartFindAll.getText(), productsPageSteps.getProductNameInCart());
        Assert.assertTrue(productsPageSteps.isProductNameInCartEnabled());
        Assert.assertTrue(productsPageSteps.isProductNameInCartDisplayed());
    }

    @Test
    public void productKitActionCartTest() {
        homePageSteps.navigateToProductCart();
        productsPageSteps.productNameAction();
        jse.executeScript("scroll(0, 2500);");
        productsPageSteps.buyKit();

        Assert.assertTrue(productsPageSteps.getKitInCartText().contains(Constants.TOGETHER_CHEAP));
    }

    @Test
    public void productActionDeleteFromCartTest() {
        homePageSteps.navigateToLaptopCategory();
        productsPageSteps.addProductInCart();
        homePageSteps.navigateToProductCart();
        homePageSteps.deleteProductFromCart();

        Assert.assertTrue(productsPageSteps.getEmptyCartText().contains(Constants.CART_IS_EMPTY));
    }

    @Test
    public void productActionWishListTest() {
        loginPageSteps.login(Constants.INPUT_FOR_LOGIN, Constants.INPUT_FOR_PASSWORD);
        homePageSteps.navigateToLaptopCategory();
        productsPageSteps.addProductInWishList();
        homePageSteps.navigateToHeaderWishList();

        Assert.assertTrue(productsPageSteps.getProductNameText().contains(Constants.LAPTOP));

        homePageSteps.deleteFromWishList();

        Assert.assertTrue(personnelAccountSteps.getEmptyWishListText().contains(Constants.EMPTY_WISH_LIST));
    }

    @Test
    public void wishListNewOwnListCreationTest() {
        loginPageSteps.login(Constants.INPUT_FOR_LOGIN, Constants.INPUT_FOR_PASSWORD);
        jseHomePage.executeScript("scroll(0, 250);");
        personnelAccountSteps.createNewWishList(Constants.LAPTOPS);

        Assert.assertTrue(personnelAccountSteps.getNameOfCreatedWishListText().contains(Constants.LAPTOPS));

        homePageSteps.navigateToLaptopCategory();
        productsPageSteps.addProductInWishList();
        homePageSteps.navigateToHeaderWishList();

        Assert.assertTrue(productsPageSteps.getProductNameText().contains(Constants.LAPTOP));

        personnelAccountSteps.deleteWishList();

        Assert.assertTrue(personnelAccountSteps.getEmptyWishListText().contains(Constants.EMPTY_WISH_LIST));
    }

    @Test
    public void outOfStackProductTest() {
        loginPageSteps.login(Constants.INPUT_FOR_LOGIN, Constants.INPUT_FOR_PASSWORD);
        homePageSteps.navigateToPlayStationCategory();
        productsPageSteps.choosePlayStationProduct();
        productsPageSteps.productTitleActions();
        productsPageSteps.notifyAboutAppearingOfProductButtonClick();
        homePageSteps.navigateToHeaderWishList();

        Assert.assertTrue(productsPageSteps.getProductNameText().contains(Constants.PLAYSTATION));

        personnelAccountSteps.deleteWishList();

        Assert.assertTrue(personnelAccountSteps.getEmptyWishListText().contains(Constants.EMPTY_WISH_LIST));
    }

    @Test
    public void comparisonOfProductsTest() {
        homePageSteps.navigateToLaptopCategory();
        productsPageSteps.comparisonButtonsOfTwoProducts();
        homePageSteps.productsComparison();

        for (WebElement element : productsPage.allProductsNotFirstOnly) {
            Assert.assertTrue(element.getText().contains(Constants.LAPTOP));
        }
    }
}
