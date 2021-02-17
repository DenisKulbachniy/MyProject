package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//li[contains(@class, 'lang')]")
    public WebElement languageRuOrUa;

    @FindBy(xpath = ".//button[@id = 'fat-menu']")
    public WebElement productsCatalogue;

    @FindBy(xpath = ".//a[contains(@class, 'hidden') and contains(text(), 'Ноутбуки')]")
    public WebElement laptopCategory;

    @FindBy(xpath = ".//rz-cart/button[contains(@class, 'header')]")
    public WebElement headerCartButton;

    @FindBy(xpath = ".//rz-comparison/button[@class='header__button']")
    public WebElement activeHeaderComparisonButton;

    @FindBy(xpath = ".//ul[contains(@class, 'comparison')]")
    public WebElement comparisonList;

    @FindBy(xpath = ".//a[@class='header-location__popular-link']")
    public List<WebElement> listOfCities;

    @FindBy(xpath = ".//button[contains(text(), 'Применить')]")
    public WebElement acceptButtonToChooseCity;

    @FindBy(xpath = ".//input[contains(@class, 'search-form')]")
    public WebElement searchField;

    @FindBy(xpath = ".//button[contains(@class,'submit')]")
    public WebElement searchButton;

    @FindBy(xpath = ".//rz-mobile-user-menu/button[@class = 'header__button']")
    public WebElement homePageAddMenu;

    @FindBy(xpath = ".//button[contains(@class, 'city')]")
    public WebElement addCityMenu;

    @FindBy(xpath = "//div[@class='catalog-empty']")
    public WebElement emptySearchResults;

    public String cities = ".//a[text()= ' %s ']";

    public HomePage(WebDriver driver) {
        super(driver);
    }
}

