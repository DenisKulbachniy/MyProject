package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public class HomePage extends BasePage {
    private final Waiter wait;

    @FindBy(xpath = "//button[@class='menu-toggler']")
    private WebElement productsCatalogue;

    @FindBy(xpath = "(//a[@class='menu__hidden-title'])[1]")
    private WebElement laptopCategory;

    @FindBy(xpath = "(//a[contains(text(),'Товары для геймеров')])[1]")
    private WebElement productForGamersCategory;

    @FindBy(xpath = "(//span[@class='popular-category__title'])[1]")
    private WebElement playstationStoreCategory;

    @FindBy(xpath = "//a[@class='header-actions__button header-actions__button_type_wish header-actions__button_state_active']")
    private WebElement activeHeaderWishListButton;

    @FindBy(xpath = "(//button[@class='header-actions__button header-actions__button_type_compare header-actions__button_state_active'])")
    private WebElement activeHeaderComparisonButton;

    @FindBy(xpath = "//ul[@class='comparison-modal__list']")
    private WebElement comparisonList;

    @FindBy(xpath = "//*[@class='button--link header-cities__label']")
    private WebElement chooseCity;

    @FindBy(xpath = "//a[@class='header-location__popular-link']")
    private WebElement listOfCities;

    @FindBy(xpath = "//button[@class='button button_size_medium button_color_green']")
    private WebElement acceptButtonToChooseCity;

    @FindBy(xpath = "//input[contains(@class, 'search-form')]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='button button_color_green button_size_medium search-form__submit']")
    private WebElement searchButton;

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

    public void inputSearchField() {
        wait.untilVisible(searchField).click();
        wait.untilVisible(searchField).sendKeys("Ноутбук");
    }

    public void searchButtonClick() {
        wait.untilVisible(searchButton).click();
    }
}
