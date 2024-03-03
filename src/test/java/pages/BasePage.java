package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;
import java.util.List;

@Getter
@Setter

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    ConfigFileReader configFileReader;

    public BasePage() {

        this.driver =  Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    //elements:

    @FindBy(how = How.ID, using = "top")
    private WebElement headerNavigationBar;

    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/button")
    private WebElement valutaIcon;

    @FindBy(how = How.CLASS_NAME, using = "fa-phone")
    private WebElement contactIcon;

    @FindBy(how = How.CLASS_NAME, using = "fa-user")
    private WebElement myAccountIcon;

    @FindBy(how = How.XPATH, using = "//a[@title='My Account']")
    private WebElement dropdownMyAccountElement;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class, 'dropdown-menu-right')]")
    private WebElement dropdownMyAccount;

    @FindBy(how = How.CLASS_NAME, using = "fa-heart")
    private WebElement wishListIcon;

    @FindBy(how = How.CLASS_NAME, using = "fa-shopping-cart")
    private WebElement shoppingCartIcon;

    @FindBy(how = How.CLASS_NAME, using = "fa-share")
    private WebElement checkoutIcon;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    public WebElement loginOption;

    @FindBy(css = "#logo > h1 > a")
    public WebElement TDStext;

    @Getter
    @FindAll(@FindBy(how = How.TAG_NAME, using = "i"))
    private List<WebElement> iconElements;

    private String urlBase = "https://www.demoshop24.com/index.php?route=";



    public void clickMyAccountMenu(String button) {
       myAccountIcon.click();
    }




}
