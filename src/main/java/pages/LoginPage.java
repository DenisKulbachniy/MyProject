package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public class LoginPage extends BasePage {

    private final Waiter wait;
    private WebDriver driver;

    @FindBy(xpath = "//button[@class='header-topline__user-link button--link']")
    private WebElement enterToAccountLink;

    @FindBy(xpath = "//*[@id='auth_email']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='auth_pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private WebElement enterButton;

    @FindBy(xpath = "/html/body/app-root/div/div[1]/app-rz-main-page/div/aside/main-page-sidebar/ul/li[2]/a")
    private WebElement accountWishList;

    @FindBy(xpath = "//button[contains(text(), 'Создать список желаний')]")
    private WebElement createNewWishList;

    @FindBy(xpath = "(//div[contains(text(), '')]/following::input[2])[1]")
    private WebElement myListOfWishes;

    @FindBy(xpath = "//*[@class='button button_size_medium button_color_navy']")
    private WebElement addNewListOfWishes;

    @FindBy(xpath = "//*[@class='wish-details__heading']")
    private WebElement nameOfCreatedWishList;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterToAccountClick() {
        wait.untilVisible(enterToAccountLink).click();
    }

    public void inputLoginField() {
        wait.untilVisible(loginField).sendKeys("Petrovartem01061996@gmail.com");
    }

    public void inputPasswordField() {
        passwordField.sendKeys("01061996Artem");
    }
        public String getNameOfWishList() {
            wait.untilVisible(nameOfCreatedWishList);
            return nameOfCreatedWishList.getText();
        }


    public void enterButtonClick() {
        wait.untilVisible(enterButton).click();
    }

    public void accountWishListClick() {
        wait.untilVisible(accountWishList).click();
    }
    public void createNewWishListClick() {
        wait.untilVisible(createNewWishList).click();
    }
    public void nameOfNewWishList(){
        myListOfWishes.sendKeys("Ноутбуки");
    }
    public void addNewListOfWishesClick(){
        wait.untilVisible(addNewListOfWishes).click();
    }

}