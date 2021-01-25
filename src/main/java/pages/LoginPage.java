package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

import java.util.List;

public class LoginPage extends BasePage {

    private final Waiter wait;

    @FindBy(xpath = ".//input[@id='auth_email']")
    private WebElement loginField;

    @FindBy(xpath = ".//input[@id='auth_pass']")
    private WebElement passwordField;

    @FindBy(xpath = ".//button[contains(@class, 'user-link')]")
    private WebElement enterToAccountLink;

    @FindBy(xpath = ".//a[@class='header-topline__user-link']")
    private WebElement enterToEnteredAccount;

    @FindBy(xpath = ".//button[contains(text(),'Войти')]")
    private WebElement enterButton;

    @FindBy(xpath = ".//li[contains(@class,'main')]//following-sibling::a[contains(text(), 'Списки')]")
    private WebElement accountWishList;

    @FindBy(xpath = ".//button[contains(text(), 'Создать')]")
    private WebElement createNewWishList;

    @FindBy(xpath = ".//input[contains(@placeholder, 'Мой список желаний')]")
    private WebElement myListOfWishes;

    @FindBy(xpath = ".//button[contains(@type, 'submit')]")
    private WebElement addNewListOfWishes;

    @FindBy(xpath = ".//h3[contains(@class,'wish')]")
    private WebElement nameOfCreatedWishList;

    @FindBy(xpath = ".//p[contains(@class, 'personal') and contains(text(),'mail.com')]")
    public List<WebElement> personnelData;

    @FindBy(xpath = ".//h3[contains(text(),'нет списков')]")
    private WebElement emptyWishList;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterToAccountClick() {
        wait.untilVisible(enterToAccountLink).click();
    }

    public void inputLoginField(String key) {
        wait.untilVisible(loginField).sendKeys(key);
    }

    public void inputPasswordField(String key) {
        wait.untilVisible(passwordField).sendKeys(key);
    }

    public String getNameOfWishList() {
        wait.untilVisible(nameOfCreatedWishList);
        return nameOfCreatedWishList.getText();
    }

    public String getEmptyWishListText() {
        wait.untilVisible(emptyWishList);
        return emptyWishList.getText();
    }

    public void enterButtonClick() {
        wait.untilVisible(enterButton).click();
    }

    public Dimension getEnterButtonSize() {
        return enterButton.getSize();
    }

    public void accountWishListClick() {
        wait.untilVisible(accountWishList).click();
    }

    public void createNewWishListClick() {
        wait.untilVisible(createNewWishList).click();
    }

    public void nameOfNewWishList(String key) {
        myListOfWishes.sendKeys(key);
    }

    public void addNewListOfWishesClick() {
        wait.untilVisible(addNewListOfWishes).click();
    }

    public void enterToEnteredAccClick() {
        wait.untilVisible(enterToEnteredAccount).click();
    }
}


