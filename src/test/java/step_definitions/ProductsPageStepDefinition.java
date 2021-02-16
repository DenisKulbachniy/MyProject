package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductsPage;
import waiters.Waiter;

public class ProductsPageStepDefinition {

    BaseStepDefinition baseStepDefinition;
    Waiter wait;
    HomePage homePage;
    ProductsPage productsPage;

    public ProductsPageStepDefinition(BaseStepDefinition baseStepDefinition) {
        this.baseStepDefinition = baseStepDefinition;
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
    }

    @When("user clicks on {string}")
    public void userClicksOnProductName(String productName) {
        wait.visibilityOfAllElementsForListOfWebElements(productsPage.productName);
        for (WebElement element : productsPage.productName) {
            if (element.getText().contains(productName)) {
                element.click();
                break;
            }
        }
    }

    @When("user adds {string} in cart")
    public void userAddsProductInCart(String productName) {
        wait.visibilityOfAllElementsForListOfWebElements(productsPage.productName);
        for (WebElement element : productsPage.productName) {
            if (element.getText().contains(productName)) {
                element.click();
                break;
            }
        }
        wait.untilVisible(productsPage.productTitle).click();
        productsPage.cartButton.click();
    }

    @Then("user can see {string} in cart")
    public void userCanSeeProductInCart(String productInCart) {
        Assert.assertTrue(getProductNameInCartText().contains(productInCart));
    }

    @When("user adds product with kit in cart")
    public void userAddsProductWithKitInCart() {
        wait.untilVisible(productsPage.buyKit).click();
    }

    @When("user adds {string} in order to compare")
    public void userAddsProductsInOrderToCompare(String productName) {
        wait.visibilityOfAllElementsForListOfWebElements(productsPage.productName);
        for (WebElement element : productsPage.productName) {
            if (element.getText().contains(productName)) {
                element.click();
                break;
            }
        }
        wait.untilVisible(productsPage.productTitle);
        productsPage.productTitle.click();
        wait.untilVisible(productsPage.comparisonOfProductsButton);
        productsPage.productTitle.click();
        productsPage.comparisonOfProductsButton.click();
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
        Assert.assertTrue(getKitInCartText().contains(kitInCart));
    }

    @Then("user can see that {string}")
    public void userCanSeeEmptyCart(String emptyCart) {
        try {
            wait.untilVisible(productsPage.emptyCart);
            wait.untilVisible(productsPage.emptyCart).click();
            Assert.assertTrue(getEmptyCartText().contains(emptyCart));
        } catch (StaleElementReferenceException e) {
        }
    }

    @Then("user can see {string}")
    public void userCanSeeComparisonProducts(String comparison) {
        Assert.assertTrue(getHeaderProductsText().contains(comparison));
    }

    @When("user switches color of product")
    public void userSwitchesColorOfProduct() {
        wait.untilVisible(productsPage.laptopColor).click();
    }

    @Then("user can see that product color is {string}")
    public void userCanSeeProductColor(String color) {
        try {
            Assert.assertTrue(getColorProductText().contains(color));
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
        try {
            for (WebElement element : productsPage.productName)
                Assert.assertTrue(element.getText().contains(brandName));
        } catch (StaleElementReferenceException e) {
        }
    }
}
