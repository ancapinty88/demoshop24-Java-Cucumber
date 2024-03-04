package pages;

import java.util.List;
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

public class PasswordPage extends BasePage {

    public static WebDriver driver;
    ConfigFileReader configFileReader;

    public PasswordPage() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmInput;
    @FindBy(css = "div .pull-left a")
    private WebElement changePasswordBackButton;
    @FindBy(css = "div .pull-right input")
    private WebElement changePasswordContinueButton;
    @FindBy(css = ".form-group.required")
    private List<WebElement> requiredElements;
    @FindBy(xpath = "//aside[@id='column-right']/div/a[3]")
    private WebElement passwordChangeLink;
}
