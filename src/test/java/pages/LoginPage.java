package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

@Getter
@Setter
//only locators
public class LoginPage extends BasePage {

    public static WebDriver driver;
    ConfigFileReader configFileReader;

    public LoginPage() {

        this.driver =  Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }


    //elements:

    @FindBy(xpath = "//li[@class='dropdown open']/ul/li[2]/a")
    private WebElement logInLink;
    @FindBy(id = "input-email")
    private WebElement eMailAddressInput;
    @FindBy(id = "input-password")
    private WebElement passwordInputField;
    @FindBy(css = "input[value='Login']")
    private WebElement logInButtonInLoginForm;

}
