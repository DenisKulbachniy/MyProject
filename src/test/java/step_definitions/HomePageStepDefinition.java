package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import pages.HomePage;
import pages.ProductsPage;
import waiters.Waiter;

public class HomePageStepDefinition {
    BaseStepDefinition baseStepDefinition;
    Waiter wait;
    HomePage homePage;
    ProductsPage productsPage;

    public HomePageStepDefinition(BaseStepDefinition baseStepDefinition) {
        this.baseStepDefinition = baseStepDefinition;
        wait = new Waiter(baseStepDefinition.driver);
        homePage = new HomePage(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);

    }

    @Given("user is on home page and switches language")
    public void userIsOnHomePageAndSwitchesLanguage() {
        homePage.openHomePage();
        wait.untilVisible(homePage.homePageAddMenu).click();
        wait.untilVisible(homePage.languageRuOrUa).click();
    }

    @When("user navigates to laptop category")
    public void userNavigatesToLaptopCategory() {
        int attempt = 0;
        while (attempt < 10) {
            try {
                wait.untilVisible(homePage.productsCatalogue);
                homePage.productsCatalogue.click();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
        wait.untilVisible(homePage.laptopCategory).click();
    }

    @When("user navigates to product cart")
    public void userNavigateToProductCart() {
        wait.untilVisible(homePage.headerCartButton).click();
    }

    @When("user removes product from cart")
    public void userRemovesProductFromCart() {
        wait.untilVisible(productsPage.contextCartMenu);
        productsPage.contextCartMenu.click();
        wait.untilVisible(productsPage.deleteButton);
        productsPage.deleteButton.click();
    }

    @When("user navigates to compare products")
    public void userNavigatesToCompareProducts() {
        wait.untilVisible(homePage.activeHeaderComparisonButton).click();
        wait.untilVisible(homePage.comparisonList).click();
    }

    @When("user wants to change city on {string}")
    public void userWantsToChangeCity(String cityName) {
        wait.untilVisible(homePage.homePageAddMenu).click();
        wait.untilVisible(homePage.addCityMenu).click();
        wait.visibilityOfAllElementsForListOfWebElements(homePage.listOfCities);
        baseStepDefinition.driver.findElement(By.xpath(String.format(homePage.cities, cityName))).click();
        wait.untilVisible(homePage.acceptButtonToChooseCity).click();
        wait.untilVisible(homePage.homePageAddMenu).click();
    }

    @When("user fills search field {string}")
    public void userFillsSearchField(String inputText) {
        try {
            wait.untilVisible(homePage.searchField).click();
            wait.untilVisible(homePage.searchField).sendKeys(inputText);
            wait.untilVisible(homePage.searchButton).click();
        } catch (StaleElementReferenceException e) {
        }
    }

    public String getChooseCityText() {
        wait.untilVisible(homePage.addCityMenu);
        return homePage.addCityMenu.getText();
    }

    public String getHeaderProductsText() {
        wait.untilVisible(productsPage.headerNameOfInput);
        return productsPage.headerNameOfInput.getText();
    }

    public String getEmptySearchResultsText() {
        wait.untilVisible(homePage.emptySearchResults);
        return homePage.emptySearchResults.getText();
    }

    @Then("user can see displayed {string}")
    public void userCanSeeDisplayedInputWord(String inputWord) {
        Assert.assertEquals(getHeaderProductsText(), inputWord);
    }

    @Then("user can see chosen city {string}")
    public void userCanSeeChosenCity(String city) {
        Assert.assertTrue(getChooseCityText().contains(city));
    }

    @Then("user can see in search {string}")
    public void userCanSeeInSearch(String searchResult) {
        Assert.assertTrue(getEmptySearchResultsText().contains(searchResult));
    }
}
