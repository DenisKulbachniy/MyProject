package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

import java.util.List;

public class ProductsPage extends BasePage {

    private final Waiter wait;

    @FindBy(xpath = "(//button[@class='buy-button goods-tile__buy-button'])[1]")
    private WebElement cartButtonOnFirstProduct;

    @FindBy(xpath = "(//div[@class='header-actions__button-wrapper'])[3]")
    private WebElement headerCartButton;

    @FindBy(xpath = "//div[@class='cart-product__main']")
    private WebElement productInCart;

    @FindBy(xpath = "(//span[@class='goods-tile__title'])[1]")
    private WebElement firstProduct;

    @FindBy(xpath = "(//span[@class='goods-tile__title'])[2]")
    private WebElement secondProduct;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<WebElement> allProductsNotFirstOnly;

    @FindBy(xpath = "//a[contains(text(),'Приставки PlayStation')]")
    private WebElement playStationCategory;

    @FindBy(xpath = "//span[contains(text(),'Игровая приставка PlayStation 5 Digital Edition')]")
    private WebElement playStationChoice;

    @FindBy(xpath = "//button[@class='button button--small button--navy']")
    private WebElement notifyAboutAppearingOfProductButton1;

    @FindBy(xpath = "//h1[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = "(//button[@class='wish-button js-wish-button'])[1]")
    private WebElement firstWishButton;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private WebElement productNameInWishList;

    @FindBy(xpath = "//button[@class='compare-button']")
    public List<WebElement> comparisonOfProductsButtons;

    @FindBy(xpath = "(//button[@class='compare-button'])[1]")
    private WebElement firstComparisonProduct;

    @FindBy(xpath = "//button[@class='button button--white button--small context-menu__toggle']")
    private WebElement addMenuForDeleteProductFromCart;

    @FindBy(xpath = "//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")
    private WebElement deleteInCartButton;

    @FindBy(xpath = "//h4[@class='cart-dummy__heading']")
    private WebElement emptyCart;

    @FindBy(xpath = "//button[@class='buy-button button button--large button--with-icon button--green buy-kit']")
    private WebElement buyKit;

    @FindBy(xpath = "//div[@class='cart-kits']")
    private WebElement kitInCart;

    @FindBy(xpath = "//button[@class='button button_color_white button_size_medium dropdown-css__toggle']")
    private WebElement addMenuInWishList;

    @FindBy(xpath = "//button[@class='button button_color_white button_size_medium dropdown-css__control js-delete-wishlist']")
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

    public List<WebElement> getAllProductsName() {
        return allProductsNotFirstOnly;
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

    public String getEmptyCartText() {
        wait.untilVisible(emptyCart);
        return emptyCart.getText();
    }

    public String getFirstProductName() {
        wait.untilVisible(firstProduct);
        return firstProduct.getText();
    }

    public void putFirstProductInCart() {
        wait.untilVisible(cartButtonOnFirstProduct).click();
    }

    public Boolean isFirstProductSelected() {
        return wait.untilVisible(cartButtonOnFirstProduct).isSelected();
    }

    public void clickToHeaderCartButton() {
        wait.untilVisible(headerCartButton).click();
    }

    public void playStationChoiceClick() {
        wait.untilVisible(playStationChoice).click();
    }

    public void notifyAboutAppearingOfProductButtonClick() {
        wait.untilVisible(notifyAboutAppearingOfProductButton1).click();
    }

    public void firstWishButtonClick() {
        wait.untilVisible(firstWishButton).click();
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