package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public class HomePageSteps extends BaseSteps {
    Waiter wait;

    public HomePageSteps(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLaptopCategory() {
        wait.untilVisible(homePage.productsCatalogue).click();
        wait.untilVisible(homePage.laptopCategory).click();
    }

    public void navigateToPlayStationCategory() {
        wait.untilVisible(homePage.productsCatalogue).click();
        wait.untilVisible(homePage.productForGamersCategory).click();
    }


    public void navigateToProductCart() {
        wait.untilVisible(homePage.headerCartButton).click();
    }

    public void deleteProductFromCart() {
        wait.untilVisible(productsPage.contextCartMenu).click();
        wait.untilVisible(productsPage.deleteButton).click();
    }

    public void navigateToHeaderWishList() {
        wait.untilVisible(homePage.activeHeaderWishListButton).click();
    }

    public void deleteFromWishList() {
        wait.untilVisible(productsPage.contextWishListMenu).click();
        wait.untilVisible(productsPage.deleteWishList).click();
    }

    public void productsComparison() {
        wait.untilVisible(homePage.activeHeaderComparisonButton).click();
        wait.untilVisible(homePage.comparisonList).click();
    }

    public void changeCity() {
        wait.untilVisible(homePage.chooseCity).click();
        wait.untilVisible(homePage.listOfCities).click();
        wait.untilVisible(homePage.acceptButtonToChooseCity).click();
    }
    public void fillInSearchFieldAndSubmit(String key) {
        wait.untilVisible(homePage.searchField).click();
        wait.untilVisible(homePage.searchField).sendKeys(key);
        wait.untilVisible(homePage.searchField).submit();
    }
    public String getChooseCityText() {
        wait.untilVisible(homePage.chooseCity);
        return homePage.chooseCity.getText();
    }
}

