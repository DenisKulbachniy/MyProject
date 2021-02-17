package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = ".//button[contains(@class, 'buy-button')]")
    public List<WebElement> cartButtons;

    @FindBy(xpath = ".//button[contains(@class, 'buy-button')]")
    public WebElement cartButton;

    @FindBy(xpath = ".//div[contains(@class, 'product__main')]")
    public WebElement productInCart;

    @FindBy(xpath = ".//h1[@class='product__title']")
    public WebElement productTitle;

    @FindBy(xpath = ".//a[contains(@class,'goods-tile__heading')]")
    public List<WebElement> productName;

    @FindBy(xpath = ".//button[@class='compare-button']")
    public List<WebElement> comparisonOfProductsButtons;

    @FindBy(xpath = ".//button[@class='compare-button']")
    public WebElement comparisonOfProductsButton;

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

    @FindBy(xpath = ".//h1[contains(@class,'heading')]")
    public WebElement headerNameOfInput;

    @FindBy(xpath = ".//a[@class='var-options__color']")
    public WebElement laptopColor;

    @FindBy(xpath = ".//p[@class='var-options__label']")
    public WebElement colorText;

    public String filterByCompany = ".//label[@for = '%s']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
}