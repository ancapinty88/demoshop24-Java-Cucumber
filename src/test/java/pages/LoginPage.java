package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigFileReader;

@Getter
@Setter
//only locators
public class LoginPage extends BasePage {

    public static WebDriver driver;
    ConfigFileReader configFileReader;
    private String logEmail;
    private String logPassword;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        logEmail = configFileReader.getEmailLogin(); // Initialize logEmail here
        logPassword = configFileReader.getPasswordLogin(); // Initialize logPassword here
    }


    //elements:

    @FindBy(xpath = "//li[@class='dropdown open']/ul/li[2]/a")
    private WebElement logInLink;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement eMailAddressInput;
    @FindBy(id = "input-password")
    private WebElement passwordInputField;
    @FindBy(xpath = "//*[@value='Login']")
    private WebElement loginPageButton;


//    @FindBy(css = "input[type='submit'][value='Login']")
//    private WebElement loginPageButton;
//    @FindBy(css = "input[type='submit'].btn.btn-primary")
//    private WebElement loginPageButton;
//    @FindBy(css = "input[value='Login']")
//    private WebElement logInButtonInLoginForm;
//    @FindBy(how = How.XPATH, using = "//input[@type='submit'][@value='Login']")
//    private WebElement buttonLogin;
}
