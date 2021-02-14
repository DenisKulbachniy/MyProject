package step_definitions;

import constants.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PersonnelAccountPage;
import pages.ProductsPage;
import waiters.Waiter;

public class PersonnelAccountStepDefinition {

    Waiter wait;
    PersonnelAccountPage personnelAccountPage;
    ProductsPage productsPage;
    private final BaseStepDefinition baseStepDefinition;


    public PersonnelAccountStepDefinition(BaseStepDefinition baseStepDefinition) {
        this.baseStepDefinition = baseStepDefinition;
    }

    @And("user navigates to account and creates new own wish list {string}")
    public void createNewWishList(String wishListName) {
        wait = new Waiter(baseStepDefinition.driver);
        personnelAccountPage = new PersonnelAccountPage(baseStepDefinition.driver);
        wait.untilVisible(personnelAccountPage.accountWishList).click();
        wait.untilVisible(personnelAccountPage.createNewWishList).click();
        wait.untilVisible(personnelAccountPage.myListOfWishes).sendKeys(wishListName);
        wait.untilVisible(personnelAccountPage.addNewListOfWishes).click();
    }

    @When("user removes own wish list")
    public void deleteWishList() {
        wait = new Waiter(baseStepDefinition.driver);
        productsPage = new ProductsPage(baseStepDefinition.driver);
        wait.untilVisible(productsPage.contextWishListMenu).click();
        wait.untilVisible(productsPage.deleteWishList).click();
    }

    public String getEmptyWishListText() {
        wait = new Waiter(baseStepDefinition.driver);
        personnelAccountPage = new PersonnelAccountPage(baseStepDefinition.driver);
        wait.untilVisible(personnelAccountPage.emptyWishList);
        return personnelAccountPage.emptyWishList.getText();
    }

    public String getNameOfCreatedWishListText() {
        wait = new Waiter(baseStepDefinition.driver);
        personnelAccountPage = new PersonnelAccountPage(baseStepDefinition.driver);
        wait.untilVisible(personnelAccountPage.nameOfCreatedWishList);
        return personnelAccountPage.nameOfCreatedWishList.getText();
    }

    @Then("user can see that wish list is empty")
    public void checkEmptyWishList() {
        Assert.assertTrue(getEmptyWishListText().contains(Constants.EMPTY_WISH_LIST));
    }

    @Then("user can see own list of wishes")
    public void checkNameOfCreatedWishList() {
        wait = new Waiter(baseStepDefinition.driver);
        personnelAccountPage = new PersonnelAccountPage(baseStepDefinition.driver);
        Assert.assertTrue(getNameOfCreatedWishListText().contains(Constants.LAPTOPS));
    }
}