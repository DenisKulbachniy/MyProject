package xpathes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Xpathes {

    @FindBy(xpath = "//button[contains(text(),'Найти')]")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Игровая приставка PlayStation 5 Digital Edition')]")
    private WebElement playStationProductChoice;

    @FindBy(xpath = "//span[starts-with(@class, 'menu-toggler__text')]")
    private WebElement productsCatalogue;

    @FindBy(xpath = "//a[starts-with(text(),'RU')]")
    private WebElement russianLanguageButton;

    @FindBy(xpath = "//a[@class='menu__hidden-title'][last()][contains(text(), 'Ноутбуки')]")
    private WebElement laptopCategory;

    @FindBy(xpath = "//a/span[last()-1]")
    private List<WebElement> availableColorOfLaptops;

    @FindBy(xpath = "//input[not(@id='auth_pass'=false())]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[not(@id='auth_email'=false())]")
    private WebElement loginField;

    @FindBy(xpath = "//button[contains(text(), 'Войти') or @class='button button--large button--green auth-modal__submit'")
    private WebElement buttonForEnterToAccount;

    @FindBy(xpath = "//button[@class='header-topline__user-link button--link' or contains(text(),'Войдите в личный кабинет')]")
    private WebElement enterToAccountLink;

    @FindBy(xpath = "//button[@class='compare-button' and @type='button']")
    private List<WebElement> comparisonButton;

    @FindBy(xpath = "//button[@class='wish-button js-wish-button' and @type='button']")
    private WebElement addToWishListButton;

    @FindBy(xpath = "//ancestor::rz-city/button[@class='button--link header-cities__label']")
    private WebElement chooseCity;

    @FindBy(xpath = "//ancestor::button[contains(text(),'Сообщить, когда появится')]")
    private WebElement outOfStackButton;

    @FindBy(xpath = "(//span[@class='goods-tile__title'])/parent::a")
    private List<WebElement> allProducts;

    @FindBy(xpath = "//p[@class='main-auth__user-name']/parent::li")
    private WebElement nameOfAccount;

    @FindBy(xpath = "//div[@class='layout']/preceding::h1[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = "//p[@class='personal-data__value']/preceding::p[contains(text(),' petrovartem01061996@gmail.com ')]")
    private WebElement personalEmailOfAccount;

    @FindBy(xpath = "//h4[contains(text(),'Корзина пуста')]/preceding-sibling::img ")
    private WebElement emptyCartImage;

    @FindBy(xpath = "//h3[contains(text(),' У вас еще нет списков желаний ')]/preceding-sibling::img")
    private WebElement wishListCapture;

    @FindBy(xpath = "//div[contains(@class, 'main-stores')]//descendant::a")
    private List<WebElement> appStoreAndGooglePlayApplications;

    @FindBy(xpath = "//li[@class='main-auth__links-item']/descendant::a[contains(text(),'Просмотренные товары')]")
    private WebElement viewProducts;

    @FindBy(xpath = "//li[@class='main-auth__links-item']//following-sibling::a[contains(text(), 'Списки желаний')]")
    private WebElement listOfWishes;

    @FindBy(xpath = "//div[@class='menu-outer js-rz-fat-menu']//following-sibling::span[@class='menu-toggler__text']")
    private WebElement mainProductsCatalogue;

    @FindBy(xpath = "//a[@class='cart-product__title'][count(a)=0]")
    private WebElement productTitleInCart;

    @FindBy(xpath = "//button[@id='cartProductActions0'][count(button)=0]")
    private WebElement additionalMenuInProductCart;

    @FindBy(xpath = "//button[@class='button button--medium button--with-icon button--link context-menu-actions__button'] | //button[contains(text(),'Удалить')] ")
    private WebElement deleteFromProductCartButton;

    @FindBy(xpath = "//a[@class='popular-category__title'] | //span[contains(text(),' PlayStation 5 ')]")
    private WebElement playStation5Category;

    @FindBy(xpath = "//li[string-length(text()) >= 110]")
    private List<WebElement> dignityOfNotebooks;

    @FindBy(xpath = "//img[@height>=40]")
    private List<WebElement> downloadFromGooglePlayOrAppStorePicture;

    @FindBy(xpath = " //*[@class='goods-tile__price-value'][number()<=100]")
    private WebElement priceLowerThan100;


    @FindBy(xpath = "//span[position() mod span = 1]")
    private List<WebElement> panelWithListOfCriteria;

    @FindBy(xpath = "//div[position() mod div = 1]")
    private WebElement blockWithProductContent;

}