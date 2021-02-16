package steps;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public class ProductsPageSteps extends BaseSteps {
    Waiter wait;

    public ProductsPageSteps(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public void productNameAction() {
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

    public void addProductInCart() {
        int attempt = 0;
        while (attempt < 5) {
            try {
                wait.visibilityOfAllElementsForListOfWebElements(productsPage.cartButtons);
                productsPage.cartButtons.get(0).click();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
    }

    public void addProductInWishList() {
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

    public void choosePlayStationProduct() {
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

    public void buyKit() {
        wait.untilVisible(productsPage.buyKit).click();
    }

    public void productTitleActions() {
        wait.untilVisible(productsPage.productTitle).click();
    }

    public String getProductNameText() {
        wait.visibilityOfAllElementsForListOfWebElements(productsPage.productName);
        return productsPage.productName.get(0).getText();
    }

    public void notifyAboutAppearingOfProductButtonClick() {
        wait.untilVisible(productsPage.notifyAboutAppearingOfProductButton).click();
    }

    public void comparisonButtonsOfTwoProducts() {
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
}

