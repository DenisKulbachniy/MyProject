package step_definitions;

import clickers.Clickers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ProductsPage;
import waiters.Waiter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsPageStepDefinition {

    BaseStepDefinition baseStepDefinition;
    Waiter wait;
    HomePage homePage;
    ProductsPage productsPage;
    Clickers clickers;

    public ProductsPageStepDefinition(BaseStepDefinition baseStepDefinition) {
        this.baseStepDefinition = baseStepDefinition;
        wait = new Waiter(baseStepDefinition.driver);
        clickers = new Clickers(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
    }

    @When("user clicks on product name {string}")
    public void userClicksOnProductName(String productName) {
        wait.staleReferenceElementExceptionCatchForListWait(productsPage.productName);
        for (WebElement element : productsPage.productName) {
            if (element.getText().contains(productName)) {
                element.click();
                break;
            }
        }
    }

    @When("user adds {string} in cart")
    public void userAddsProductInCart(String productName) {
        wait.staleReferenceElementExceptionCatchForListWait(productsPage.productName);
        for (WebElement element : productsPage.productName) {
            if (element.getText().contains(productName)) {
                element.click();
                break;
            }
        }
        wait.untilVisible(productsPage.productTitle).click();
        wait.elementToBeClickableWait(productsPage.cartButton).click();
    }

    @Then("user can see {string} in cart")
    public void userCanSeeProductInCart(String productInCart) {
        assertEquals("Values are not equals", getProductNameInCartText(), productInCart);
    }

    @When("user adds product with kit in cart")
    public void userAddsProductWithKitInCart() {
        wait.untilVisible(productsPage.buyKit).click();
    }

    @When("user adds product {string} in order to compare")
    public void userAddsProductsInOrderToCompare(String productName) {
        wait.staleReferenceElementExceptionCatchForListWait(productsPage.productName);
        for (WebElement element : productsPage.productName) {
            if (element.getText().contains(productName)) {
                element.click();
                break;
            }
        }
        clickers.clickButtonWithStaleReferenceElementException(productsPage.comparisonOfProductsButton);
    }

    public String getKitInCartText() {
        wait.untilVisible(productsPage.kitInCart);
        return productsPage.kitInCart.getText();
    }

    public String getProductNameInCartText() {
        wait.untilVisible(productsPage.productInCart);
        return productsPage.productInCart.getText();
    }

    public String getEmptyCartText() {
        wait.untilVisible(productsPage.emptyCart);
        return productsPage.emptyCart.getText();
    }

    public String getHeaderProductsText() {
        wait.untilVisible(productsPage.headerNameOfInput);
        return productsPage.headerNameOfInput.getText();
    }

    public String getColorProductText() {
        wait.untilVisible(productsPage.colorText);
        return productsPage.colorText.getText();
    }

    @Then("user can see added product with {string} in cart")
    public void userCanSeeAddedProductWithKitInCart(String kitInCart) {
        assertTrue("Values are not equals", getKitInCartText().contains(kitInCart));
    }

    @Then("user can see that {string}")
    public void userCanSeeEmptyCart(String emptyCart) {
        try {
            wait.untilVisible(productsPage.emptyCart);
            wait.untilVisible(productsPage.emptyCart).click();
            assertEquals("Values are not equals", getEmptyCartText(), emptyCart);
        } catch (StaleElementReferenceException e) {
        }
    }

    @Then("user can see {string}")
    public void userCanSeeComparisonProducts(String comparison) {
        assertEquals("Values are not equals", getHeaderProductsText(), comparison);
    }

    @When("user switches color of product")
    public void userSwitchesColorOfProduct() {
        wait.untilVisible(productsPage.laptopColor).click();
    }

    @Then("user can see that product color is {string}")
    public void userCanSeeProductColor(String color) {
        try {
            assertTrue("Values are not equals", getColorProductText().contains(color));
        } catch (StaleElementReferenceException e) {
        }
    }

    @When("user chooses laptops by brand {string}")
    public void userChoosesLaptopsByBrand(String brandName) {
        wait.visibilityOfAllElementsForListOfWebElements(productsPage.productName);
        baseStepDefinition.driver.findElement(By.xpath(String.format(productsPage.filterByCompany, brandName))).click();
    }

    @Then("user can see filtered laptops by brand {string}")
    public void userCanSeeFilteredLaptopsByBrand(String brandName) {
        for (WebElement element : productsPage.productName)
            assertTrue("Not all elements are not contain brandName", element.getText().contains(brandName));
    }
}
