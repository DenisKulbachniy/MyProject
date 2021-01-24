package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

import java.util.List;

public class ProductsPage extends BasePage {

    private final Waiter wait;

    @FindBy(xpath = ".//button[contains(@class, 'buy-button')]")
    public List<WebElement> cartButton;

    @FindBy(xpath = ".//a[contains(@class, 'basket')]")
    private WebElement headerCartButton;

    @FindBy(xpath = ".//div[contains(@class, 'product__main')]")
    private WebElement productInCart;

    @FindBy(xpath = "(.//span[@class='goods-tile__title'])[1]")    // i need it
    private WebElement firstProduct;

    @FindBy(xpath = ".//span[contains(@class, 'tile__title')]")
    public List<WebElement> allProductsNotFirstOnly;

    @FindBy(xpath = ".//span[contains(text(),'PlayStation 5')]")
    public List<WebElement> playStationProductChoice;

    @FindBy(xpath = ".//button[contains(text(),'Сообщить')]")
    private WebElement notifyAboutAppearingOfProductButton;

    @FindBy(xpath = ".//h1[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = ".//button[contains(@class, 'wish')]")
    public List<WebElement> wishButton;

    @FindBy(xpath = ".//span[contains(@class,'tile__title')]")
    private WebElement productNameInWishList;

    @FindBy(xpath = ".//button[@class='compare-button']")
    public List<WebElement> comparisonOfProductsButtons;

    @FindBy(xpath = "(.//button[@class='compare-button'])[1]")
    public WebElement firstComparisonProduct;

    @FindBy(xpath = ".//button[contains(@class, 'context-menu')]")
    private WebElement addMenuForDeleteProductFromCart;

    @FindBy(xpath = ".//button[contains(@class, 'menu-actions')]")
    private WebElement deleteInCartButton;

    @FindBy(xpath = ".//h4[contains(@class, 'cart')]")
    private WebElement emptyCart;

    @FindBy(xpath = ".//button[contains(@class, 'buy-kit')]")
    private WebElement buyKit;

    @FindBy(xpath = ".//div[@class='cart-kits']")
    private WebElement kitInCart;

    @FindBy(xpath = ".//button[contains(@class, 'dropdown-css__toggle')]")
    private WebElement addMenuInWishList;

    @FindBy(xpath = ".//button[contains(@class, 'delete-wishlist')]")
    private WebElement deleteWishList;

    public ProductsPage(WebDriver driver) {
        super(driver);
        wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductNameInWishList() {
        wait.untilVisible(productNameInWishList);
        return productNameInWishList.getText();
    }

    public String getKitInCartText() {
        wait.untilVisible(kitInCart);
        return kitInCart.getText();
    }

    public String getProductNameInCart() {
        wait.untilVisible(productInCart);
        return productInCart.getText();
    }

    public Boolean isProductNameInCartEnabled() {
        wait.untilVisible(productInCart);
        return productInCart.isEnabled();
    }

    public Boolean isProductNameInCartDisplayed() {
        wait.untilVisible(productInCart);
        return productInCart.isDisplayed();
    }

    public void isFirstProductDisplayed() {
        wait.untilVisible(firstProduct).isDisplayed();
    }

    public String getEmptyCartText() {
        wait.untilVisible(emptyCart);
        return emptyCart.getText();
    }

    public String getFirstProductName() {
        wait.untilVisible(firstProduct);
        return firstProduct.getText();
    }

    public void clickToHeaderCartButton() {
        wait.untilVisible(headerCartButton).click();
    }

    public void notifyAboutAppearingOfProductButtonClick() {
        wait.untilVisible(notifyAboutAppearingOfProductButton).click();
    }

    public void clickToFirstProduct() {
        wait.untilVisible(firstProduct).click();
    }

    public void clickToProductTitle() {
        wait.untilVisible(productTitle).click();
    }

    public void isComparisonButtonEnabled() {
        wait.untilVisible(firstComparisonProduct).isEnabled();
    }

    public void clickToDeleteInCartButton() {
        wait.untilVisible(deleteInCartButton).click();
    }

    public void addMenuForDeleteProductFromCartClick() {
        wait.untilVisible(addMenuForDeleteProductFromCart).click();
    }

    public void buyKitClick() {
        wait.untilVisible(buyKit).click();
    }

    public void addMenuInWishListClick() {
        wait.untilVisible(addMenuInWishList).click();
    }

    public void deleteWishListClick() {
        wait.untilVisible(deleteWishList).click();
    }
}