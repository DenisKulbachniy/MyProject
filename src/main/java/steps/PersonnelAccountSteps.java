package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public class PersonnelAccountSteps extends BaseSteps {
    Waiter wait;

    public PersonnelAccountSteps(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public void createNewWishList(String wishListName) {
        wait.untilVisible(personnelAccountPage.accountWishList).click();
        wait.untilVisible(personnelAccountPage.createNewWishList).click();
        wait.untilVisible(personnelAccountPage.myListOfWishes).sendKeys(wishListName);
        wait.untilVisible(personnelAccountPage.addNewListOfWishes).click();
    }

    public void deleteWishList() {
        wait.untilVisible(productsPage.contextWishListMenu).click();
        wait.untilVisible(productsPage.deleteWishList).click();
    }

    public String getEmptyWishListText() {
        wait.untilVisible(personnelAccountPage.emptyWishList);
        return personnelAccountPage.emptyWishList.getText();
    }

    public String getNameOfCreatedWishListText() {
        wait.untilVisible(personnelAccountPage.nameOfCreatedWishList);
        return personnelAccountPage.nameOfCreatedWishList.getText();
    }
}
