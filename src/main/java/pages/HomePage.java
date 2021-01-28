package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

import java.util.List;

public class HomePage extends BasePage {
    Waiter wait;

    @FindBy(xpath = ".//li[contains(@class, 'language')]")
    public List<WebElement> languageRuOrUa;

    @FindBy(xpath = ".//span[starts-with(@class, 'menu-toggler')]")
    public WebElement productsCatalogue;

    @FindBy(xpath = ".//a[contains(@class, 'hidden') and contains(text(), 'Ноутбуки')]")
    public WebElement laptopCategory;

    @FindBy(xpath = ".//a[contains(@class, 'basket')]")
    public WebElement headerCartButton;

    @FindBy(xpath = ".//a[contains(@class,'hidden') and contains(text(), 'Товары для геймеров')]")
    public WebElement productForGamersCategory;

    @FindBy(xpath = ".//span[contains(@class, 'popular') and contains(text(),'PlayStation')]")
    public WebElement playstationStoreCategory;

    @FindBy(xpath = ".//a[contains(@class, 'wish header')]")
    public WebElement activeHeaderWishListButton;

    @FindBy(xpath = ".//button[contains(@class, 'compare header')]")
    public WebElement activeHeaderComparisonButton;

    @FindBy(xpath = ".//ul[contains(@class, 'comparison')]")
    public WebElement comparisonList;

    @FindBy(xpath = ".//button[contains(@class, 'header-cities')]")
    public WebElement chooseCity;

    @FindBy(xpath = ".//a[@class='header-location__popular-link']")
    public WebElement listOfCities;

    @FindBy(xpath = ".//button[contains(text(), 'Применить')]")
    public WebElement acceptButtonToChooseCity;

    @FindBy(xpath = ".//input[contains(@class, 'search-form')]")
    public WebElement searchField;

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }
}

