package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = ".//input[@id='auth_email']")
    public WebElement loginField;

    @FindBy(xpath = ".//input[@id='auth_pass']")
    public WebElement passwordField;

    @FindBy(xpath = ".//button[contains(@class, 'user-link')]")
    public WebElement enterToAccountLink;

    @FindBy(xpath = ".//a[@class='header-topline__user-link']")
    public WebElement enterToEnteredAccount;

    @FindBy(xpath = ".//button[contains(text(),'Войти')]")
    public WebElement enterButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}


