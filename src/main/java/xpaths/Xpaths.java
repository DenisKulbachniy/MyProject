package xpaths;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Xpaths {

    @FindBy(xpath = ".//button[contains(text(),'Найти')]")
    private WebElement searchButton;

    @FindBy(xpath = ".//span[contains(text(),'PlayStation 5')]")
    private List<WebElement> playStationProductChoice;

    @FindBy(xpath = ".//span[starts-with(@class, 'menu')]")
    private List<WebElement> productsCatalogue;

    @FindBy(xpath = ".//span[starts-with(text() , ' Ноутбук Dell ' )]")
    private WebElement russianLanguageButton;

    @FindBy(xpath = ".//a[contains(@class, 'hidden')][last()][contains(text(), 'Ноутбуки')]")
    private WebElement laptopCategory;

    @FindBy(xpath = ".//a/span[last()-1]")
    private List<WebElement> availableColorOfLaptops;

    @FindBy(xpath = ".//li[contains(@class, 'header-topline')][not(a)]")
    private WebElement selectedLanguageButton;

    @FindBy(xpath = ".//div[contains(@class, 'available')][not(contains(@class, 'unavailable'))]")
    private WebElement availableProducts;

    @FindBy(xpath = ".//button[contains(text(), 'Войти') or @class='submit']")
    private WebElement buttonForEnterToAccount;

    @FindBy(xpath = ".//button[contains(@class, 'user-link') or contains(text(),'кабинет')]")
    private WebElement enterToAccountLink;

    @FindBy(xpath = ".//button[@class='compare-button' and @type='button']")
    private List<WebElement> comparisonButtons;

    @FindBy(xpath = ".//button[@class='wish-button js-wish-button' and @type='button']")
    private WebElement addToWishListButton;

    @FindBy(xpath = ".//button[@class='button--link header-cities__label']/ancestor::rz-city")
    private WebElement chooseCity;

    @FindBy(xpath = ".//button[contains(text(),'Сообщить')]/ancestor::rz-button-notify")
    private WebElement outOfStackButton;

    @FindBy(xpath = "(.//span[@class='goods-tile__title'])/parent::a")
    private List<WebElement> allProducts;

    @FindBy(xpath = ".//p[@class='main-auth__user-name']/parent::li")
    private WebElement nameOfAccount;

    @FindBy(xpath = ".//div[@class='layout']/preceding::h1[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = ".//a[contains(@class, 'info')]/preceding::li[contains(@class, 'tags')]")
    private WebElement addCriteriaOfNotebooksOnBottomPage;

    @FindBy(xpath = ".//h4[contains(text(),'Корзина пуста')]/preceding-sibling::img ")
    private WebElement emptyCartImage;

    @FindBy(xpath = ".//h3[contains(text(),' У вас еще нет списков желаний ')]/preceding-sibling::img")
    private WebElement wishListCapture;

    @FindBy(xpath = ".//div[contains(@class, 'main-stores')]//descendant::a")
    private List<WebElement> appStoreAndGooglePlayApplications;

    @FindBy(xpath = ".//li[contains(@class, 'main')]/descendant::a[contains(text(),'Просмотренные')]")
    private WebElement viewProducts;

    @FindBy(xpath = ".//li[contains(@class,'main')]//following-sibling::a[contains(text(), 'Списки')]")
    private WebElement listOfWishes;

    @FindBy(xpath = ".//div[contains(@class,'menu')]//following-sibling::span[contains(@class,'menu')]")
    private WebElement mainProductsCatalogue;

    @FindBy(xpath = ".//span[count(span)=1]")
    private WebElement mainCriteriaListOfNotebookChoice;

    @FindBy(xpath = ".//button[count(i)=1]")
    private WebElement headerComparisonButton;

    @FindBy(xpath = ".//button[contains(@class,'menu-actions')] | //button[contains(text(),'Удалить')] ")
    private WebElement deleteFromProductCartButton;

    @FindBy(xpath = ".//a[contains(@class, 'popular')] | //span[contains(text(),' PlayStation 5 ')]")
    private WebElement playStation5Category;

    @FindBy(xpath = ".//li[string-length(text()) >= 110]")
    private List<WebElement> dignityOfNotebooks;

    @FindBy(xpath = ".//img[@height>=40]")
    private List<WebElement> downloadFromGooglePlayOrAppStorePicture;

    @FindBy(xpath = ".//*[@class='goods-tile__price-value'][number()<=100]")
    private WebElement priceLowerThan100;

    @FindBy(xpath = ".//span[position() mod span = 1]")
    private List<WebElement> panelWithListOfCriteria;

    @FindBy(xpath = ".//div[position() mod div = 1]")
    private WebElement blockWithProductContent;
}