package pages;


import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
@Setter
public class EditAccountPage extends BasePage {

    static BasePage basePage;

    @FindBy(xpath = "//aside[@id='column-right']/div/a[2]")
    private WebElement editAccountLink;
    @FindBy(css = "fieldset legend")
    private WebElement editAccountSubTitle;
    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-email")
    private WebElement EmailInput;
    @FindBy(id = "input-telephone")
    private WebElement TelephoneInput;
    @FindBy(css = "div .pull-left a")
    private WebElement editAccountBackButton;
    @FindBy(css = "div .pull-right input")
    private WebElement editAccountContinueButton;
    @FindBy(css = "div .alert")
    private WebElement successMessage;
    @FindBy(css = ".form-group.required")
    private List<WebElement> requiredElements;


}