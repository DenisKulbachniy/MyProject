package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = ".//button[contains(@class, 'buy-button')]")
    public List<WebElement> cartButton;

    @FindBy(xpath = ".//div[contains(@class, 'product__main')]")
    public WebElement productInCart;

    @FindBy(xpath = ".//span[contains(text(),'PlayStation 5')]")
    public List<WebElement> playStationProductChoice;

    @FindBy(xpath = ".//button[contains(text(),'Сообщить')]")
    public WebElement notifyAboutAppearingOfProductButton;

    @FindBy(xpath = ".//h1[@class='product__title']")
    public WebElement productTitle;

    @FindBy(xpath = ".//button[contains(@class, 'wish')]")
    public List<WebElement> wishButton;

    @FindBy(xpath = ".//span[contains(@class,'tile__title')]")
    public List<WebElement> productName;

    @FindBy(xpath = ".//button[@class='compare-button']")
    public List<WebElement> comparisonOfProductsButtons;

    @FindBy(xpath = ".//button[contains(@class, 'context-menu')]")
    public WebElement contextCartMenu;

    @FindBy(xpath = ".//button[contains(@class, 'menu-actions')]")
    public WebElement deleteButton;

    @FindBy(xpath = ".//h4[contains(@class, 'cart')]")
    public WebElement emptyCart;

    @FindBy(xpath = ".//button[contains(@class, 'buy-kit')]")
    public WebElement buyKit;

    @FindBy(xpath = ".//div[@class='cart-kits']")
    public WebElement kitInCart;

    @FindBy(xpath = ".//button[contains(@class, 'dropdown-css__toggle')]")
    public WebElement contextWishListMenu;

    @FindBy(xpath = ".//button[contains(@class, 'delete-wishlist')]")
    public WebElement deleteWishList;

    @FindBy(xpath = ".//h1[contains(@class,'heading')]")
    public WebElement headerNameOfInput;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}