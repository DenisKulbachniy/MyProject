package step_definitions;

import constants.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.PersonnelAccountPage;
import pages.ProductsPage;
import waiters.Waiter;

public class HomePageStepDefinition {
    private final BaseStepDefinition baseStepDefinition;
    Waiter wait;
    HomePage homePage;
    ProductsPage productsPage;
    PersonnelAccountPage personnelAccountPage;

    public HomePageStepDefinition(BaseStepDefinition baseStepDefinition) {
        this.baseStepDefinition = baseStepDefinition;
    }

    @Given("user is on home page")
    public void openHomePageAndSwitchLanguage() {
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        homePage.openHomePage();
        wait.untilVisible(homePage.homePageAddMenu).click();
        wait.untilVisible(homePage.languageRuOrUa).click();
    }

    @When("user navigates to laptop category")
    public void navigateToLaptopCategory() {
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        wait.untilVisible(homePage.productsCatalogue).click();
        wait.untilVisible(homePage.laptopCategory).click();
    }

    @And("user navigate to playstation category")
    public void navigateToPlayStationCategory() {
        homePage = new HomePage(baseStepDefinition.driver);
        wait.untilVisible(homePage.productsCatalogue).click();
        wait.untilVisible(homePage.productForGamersCategory).click();
    }

    @And("user navigates to product cart")
    public void navigateToProductCart() {
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        wait.untilVisible(homePage.headerCartButton).click();
    }

    @And("user removes product from cart")
    public void deleteProductFromCart() {
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait.untilVisible(productsPage.contextCartMenu).click();
        wait.untilVisible(productsPage.deleteButton).click();
    }

    @And("user navigates on header wish list")
    public void navigateToHeaderWishList() {
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        personnelAccountPage = new PersonnelAccountPage(baseStepDefinition.driver);
        wait.untilVisible(homePage.activeHeaderWishListButton).click();
    }

    @When("user removes product from wish list")
    public void deleteFromWishList() {
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait = new Waiter(baseStepDefinition.driver);
        wait.untilVisible(productsPage.contextWishListMenu).click();
        wait.untilVisible(productsPage.deleteWishList).click();
    }

    @And("user navigates to compare products")
    public void productsComparison() {
        homePage = new HomePage(baseStepDefinition.driver);
        wait = new Waiter(baseStepDefinition.driver);
        wait.untilVisible(homePage.activeHeaderComparisonButton).click();
        wait.untilVisible(homePage.comparisonList).click();
    }

    @When("user wants to change city")
    public void changeCity() {
        homePage = new HomePage(baseStepDefinition.driver);
        wait = new Waiter(baseStepDefinition.driver);
        wait.untilVisible(homePage.homePageAddMenu).click();
        wait.untilVisible(homePage.addCityMenu).click();
        wait.visibilityOfAllElementsForListOfWebElements(homePage.listOfCities);
        chooseCity();
        wait.untilVisible(homePage.homePageAddMenu).click();
    }

    public void chooseCity() {
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        int attempt = 0;
        while (attempt < 1) {
            try {
                homePage.listOfCities.get(0).click();
                wait.untilVisible(homePage.acceptButtonToChooseCity).click();
            } catch (Exception e) {
                attempt++;
            }
        }
    }

    @When("user fills search field {string}")
    public void fillInSearchFieldAndSubmit(String inputText) {
        homePage = new HomePage(baseStepDefinition.driver);
        wait = new Waiter(baseStepDefinition.driver);
        wait.untilVisible(homePage.searchField).click();
        wait.untilVisible(homePage.searchField).sendKeys(inputText);
        wait.untilVisible(homePage.searchButton).click();
    }

    public String getChooseCityText() {
        homePage = new HomePage(baseStepDefinition.driver);
        wait.untilVisible(homePage.addCityMenu);
        return homePage.addCityMenu.getText();
    }

    public String getHeaderProductsText() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait.untilVisible(productsPage.headerNameOfInput);
        return productsPage.headerNameOfInput.getText();
    }

    @Then("user can see that input word is displayed")
    public void checkSearch() {
        Assert.assertEquals(getHeaderProductsText(), Constants.LAPTOPS);
    }

    @Then("user can see chosen city")
    public void checkChosenCity() {
        Assert.assertTrue(getChooseCityText().contains(Constants.KIEV));
    }
}
