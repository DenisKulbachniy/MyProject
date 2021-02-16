package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public class PersonnelAccountPage extends BasePage{
    Waiter wait;

    @FindBy(xpath = ".//li[contains(@class,'main')]//following-sibling::a[contains(text(), 'Списки')]")
    public WebElement accountWishList;

    @FindBy(xpath = ".//button[contains(text(), 'Создать')]")
    public WebElement createNewWishList;

    @FindBy(xpath = ".//input[contains(@placeholder, 'Мой список желаний')]")
    public WebElement myListOfWishes;

    @FindBy(xpath = ".//button[contains(@type, 'submit')]")
    public WebElement addNewListOfWishes;

    @FindBy(xpath = ".//h3[contains(@class,'wish')]")
    public WebElement nameOfCreatedWishList;

    @FindBy(xpath = ".//h3[contains(text(),'У вас еще нет списков желаний')]")
    public WebElement emptyWishList;

    public PersonnelAccountPage(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }
}
