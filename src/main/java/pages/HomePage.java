package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

import java.util.List;

public class HomePage extends BasePage {
    private final Waiter wait;
    private static final String LAPTOPS = "Ноутбуки";

    @FindBys({
            @FindBy(xpath = ".//button[contains(text(),'Найти')]"),
            @FindBy(xpath = ".//button[contains(@class,'form__submit')]")
    })
    public WebElement searchButtonFindBys;

    @FindBy(xpath = ".//img[contains(@title, 'Rozetka.ua')]")
    public WebElement rozetkaImg;

    @FindBy(xpath = ".//li[contains(@class, 'language')]")
    public List<WebElement> languageRuOrUa;

    @FindBy(xpath = ".//span[starts-with(@class, 'menu')]")
    public WebElement productsCatalogue;

    @FindBy(xpath = ".//a[contains(@class, 'hidden') and contains(text(), 'Ноутбуки')]")
    private WebElement laptopCategory;

    @FindBy(xpath = ".//a[contains(@class,'hidden') and contains(text(), 'Товары для геймеров')]")
    private WebElement productForGamersCategory;

    @FindBy(xpath = ".//span[contains(@class, 'popular') and contains(text(),'PlayStation')]")
    private WebElement playstationStoreCategory;

    @FindBy(xpath = ".//a[contains(@class, 'wish header')]")
    private WebElement activeHeaderWishListButton;

    @FindBy(xpath = ".//button[contains(@class, 'compare header')]")
    private WebElement activeHeaderComparisonButton;

    @FindBy(xpath = ".//ul[contains(@class, 'comparison')]")
    private WebElement comparisonList;

    @FindBy(xpath = ".//button[contains(@class, 'header-cities')]")
    private WebElement chooseCity;

    @FindBy(xpath = ".//a[@class='header-location__popular-link']")
    private WebElement listOfCities;

    @FindBy(xpath = ".//button[contains(text(), 'Применить')]")
    private WebElement acceptButtonToChooseCity;

    @FindBy(xpath = ".//input[contains(@class, 'search-form')]")
    private WebElement searchField;

    @FindBy(xpath = ".//button[contains(text(),'Найти')]")
    public WebElement searchButton;

    @FindBy(xpath = ".//div[contains(@class, 'input-wrapper')]")
    public WebElement emptySearchField;

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public String chooseCityGetText() {
        wait.untilVisible(chooseCity);
        return chooseCity.getText();
    }

    public void navigateToCategoriesFromMainPage() {
        wait.untilVisible(productsCatalogue).click();
    }

    public void navigateToLaptopCategory() {
        wait.untilVisible(laptopCategory).click();
    }

    public void productForGamersCategoryClick() {
        wait.untilVisible(productForGamersCategory).click();
    }

    public void playstationCategoryClick() {
        wait.untilVisible(playstationStoreCategory).click();
    }

    public void activeHeaderWishListButtonClick() {
        wait.untilVisible(activeHeaderWishListButton).click();
    }

    public void activeHeaderComparisonButtonClick() {
        wait.untilVisible(activeHeaderComparisonButton).click();
    }

    public void comparisonListClick() {
        wait.untilVisible(comparisonList).click();
    }

    public void chooseCityClick() {
        wait.untilVisible(chooseCity).click();
    }

    public void chooseCityFromListOfCitiesClick() {
        wait.untilVisible(listOfCities).click();
    }

    public void acceptButtonToChooseCityClick() {
        wait.untilVisible(acceptButtonToChooseCity).click();
    }

    public void inputSearchField(String key) {
        wait.untilVisible(searchField).click();
        wait.untilVisible(searchField).sendKeys(key);
    }

    public void clearSearchFieldAfterInput() {
        searchField.clear();
    }

    public void submitSearch() {
        wait.untilVisible(searchField).submit();
    }

    public void laptopsTextIsPresent() {
        wait.textToBePresentInElementWaiter(laptopCategory, LAPTOPS);
    }
}

