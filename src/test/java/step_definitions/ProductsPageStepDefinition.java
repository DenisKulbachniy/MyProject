package step_definitions;

import constants.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductsPage;
import waiters.Waiter;

public class ProductsPageStepDefinition {

    private final BaseStepDefinition baseStepDefinition;
    Waiter wait;
    HomePage homePage;
    ProductsPage productsPage;

    public ProductsPageStepDefinition(BaseStepDefinition baseStepDefinition) {
        this.baseStepDefinition = baseStepDefinition;
    }

    @And("user clicks on product")
    public void productNameAction() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        int attempt = 0;
        while (attempt < 5) {
            try {
                wait.visibilityOfAllElementsForListOfWebElements(productsPage.productName);
                productsPage.productName.get(0).click();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
    }

    @And("user adds product in cart")
    public void addProductInCart() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        int attempt = 0;
        while (attempt < 5) {
            try {
                wait.visibilityOfAllElementsForListOfWebElements(productsPage.cartButton);
                productsPage.cartButton.get(0).click();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
    }

    @Then("user can see product in cart")
    public void checkProductInCart() {
        productsPage = new ProductsPage(baseStepDefinition.driver);
        Assert.assertTrue(getProductNameInCartText().contains(Constants.LAPTOP));
    }

    @And("user adds product in wish list")
    public void addProductInWishList() {
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait = new Waiter(baseStepDefinition.driver);
        int attempt = 0;
        while (attempt < 5) {
            try {
                wait.visibilityOfAllElementsForListOfWebElements(productsPage.wishButton);
                productsPage.wishButton.get(0).click();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
    }

    @And("user chooses out of stock product")
    public void choosePlayStationProduct() {
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        int attempt = 0;
        while (attempt < 1) {
            try {
                wait.untilVisible(homePage.playstationStoreCategory).click();
                wait.untilVisible(productsPage.playStationProductChoice.get(0)).click();
                wait.untilVisible(productsPage.productTitle).click();
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
    }

    @And("user adds product with kit in cart")
    public void buyKit() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait.untilVisible(productsPage.buyKit).click();
    }

    public void productTitleActions() {
        wait.untilVisible(productsPage.productTitle).click();
    }

    public String getProductNameText() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait.visibilityOfAllElementsForListOfWebElements(productsPage.productName);
        return productsPage.productName.get(0).getText();
    }

    @And("user wants to notify himself about in stock of product")
    public void notifyAboutAppearingOfProductButtonClick() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait.untilVisible(productsPage.notifyAboutAppearingOfProductButton).click();
    }

    @And("user adds a few products in order to compare")
    public void comparisonButtonsOfTwoProducts() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        int attempt = 0;
        while (attempt < 5) {
            try {
                wait.visibilityOfAllElementsForListOfWebElements(productsPage.comparisonOfProductsButtons);
                productsPage.comparisonOfProductsButtons.get(0).click();
                wait.visibilityOfAllElementsForListOfWebElements(productsPage.comparisonOfProductsButtons);
                productsPage.comparisonOfProductsButtons.get(1).click();
            } catch (Exception e) {
            }
            attempt++;
        }
    }

    public String getKitInCartText() {
        wait.untilVisible(productsPage.kitInCart);
        return productsPage.kitInCart.getText();
    }

    public String getProductNameInCartText() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait.untilVisible(productsPage.productInCart);
        return productsPage.productInCart.getText();
    }

    public Boolean isProductNameInCartEnabled() {
        wait.untilVisible(productsPage.productInCart);
        return productsPage.productInCart.isEnabled();
    }

    public Boolean isProductNameInCartDisplayed() {
        wait.untilVisible(productsPage.productInCart);
        return productsPage.productInCart.isDisplayed();
    }

    public String getEmptyCartText() {
        wait.untilVisible(productsPage.emptyCart);
        return productsPage.emptyCart.getText();
    }

    public String getHeaderProductsText() {
        wait.untilVisible(productsPage.headerNameOfInput);
        return productsPage.headerNameOfInput.getText();
    }

    @Then("user can see his product with kit in cart")
    public void checkProductKitInCart() {
        productsPage = new ProductsPage(baseStepDefinition.driver);
        Assert.assertTrue(getKitInCartText().contains(Constants.TOGETHER_CHEAP));
    }

    @Then("user can see that cart is empty")
    public void checkEmptyCart() {
        Assert.assertTrue(getEmptyCartText().contains(Constants.CART_IS_EMPTY));
    }

    @Then("user can see product in wish list")
    public void checkWishList() {
        Assert.assertTrue(getProductNameText().contains(Constants.LAPTOP));
    }

    @Then("user can see out of stock product")
    public void checkOutOfStockProduct() {
        Assert.assertTrue(getProductNameText().contains(Constants.PLAYSTATION));
    }

    @Then("user can see comparison products")
    public void checkComparisonProducts() {
        Assert.assertTrue(getHeaderProductsText().contains(Constants.COMPARING_LAPTOPS));
    }
}