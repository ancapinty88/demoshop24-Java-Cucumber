package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EPIC02MyAccountPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Account')]/following-sibling::ul[1]")
    public WebElement myAccountBlock;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Orders')]/following-sibling::ul[1]")
    public WebElement myOrdersBlock;
    @FindBy(how = How.CSS, using = ".list-unstyled [href*='route=account/edit']")
    public WebElement editAccountInfoLink;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Account')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> myAccountLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Orders')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> myOrdersLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Affiliate Account')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> myAffiliateAccountLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Newsletter')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> newsletterLinks;
    @FindBy(how = How.CSS, using = "#column-right .list-group a")
    public static List<WebElement> rightMenuLinks;
    @FindBy(how = How.CSS, using = "#column-right .list-group [href*='route=account/edit']")
    public static WebElement editAccountBtnMenuRight;
    @FindBy(how = How.TAG_NAME, using = "legend")
    public static WebElement myAccountPageSubtitle;
    @FindBy(how = How.ID, using = "input-firstname")
    public static WebElement firstNameAtEditAccount;
    @FindBy(how = How.ID, using = "input-lastname")
    public static WebElement lastNameAtEditAccount;
    @FindBy(how = How.ID, using = "input-email")
    public static WebElement emailAtEditAccount;
    @FindBy(how = How.ID, using = "input-telephone")
    public static WebElement telephoneAtEditAccount;
    @FindBy(how = How.CLASS_NAME, using = "btn-default")
    public static WebElement buttonBackAtEditAccount;
    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    public static WebElement buttonContinueAtEditAccount;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-firstname']")
    public WebElement firstNameForAsteriskAtEdit;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-lastname']")
    public WebElement lastNameForAsteriskAtEdit;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-email']")
    public WebElement emailForAsteriskAtEdit;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-telephone']")
    public WebElement telephoneForAsteriskAtEdit;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),' Success: Your account has been successfully updated.')]")
    public WebElement successfulAccountUpdateMessage;

    public Map<String, WebElement> getFieldsButtonsLocatedWhenEditAccount () {
        Map<String, WebElement>fieldsButtonsLocated = new HashMap<>();
        fieldsButtonsLocated.put("firstName", firstNameAtEditAccount);
        fieldsButtonsLocated.put("lastName", lastNameAtEditAccount);
        fieldsButtonsLocated.put("email", emailAtEditAccount);
        fieldsButtonsLocated.put("telephone", telephoneAtEditAccount);
        fieldsButtonsLocated.put("buttonBack", buttonBackAtEditAccount);
        fieldsButtonsLocated.put("buttonContinue", buttonContinueAtEditAccount);
        return fieldsButtonsLocated;
    }

    public static void clickEditAccountBtnMenuRight() {
        editAccountBtnMenuRight.click();
    }

    public Map<String, WebElement> getAsteriskLocators () {
        Map<String, WebElement>asteriskLocators = new HashMap<>();
        asteriskLocators.put("firstName", firstNameForAsteriskAtEdit);
        asteriskLocators.put("lastName", lastNameForAsteriskAtEdit);
        asteriskLocators.put("email", emailForAsteriskAtEdit);
        asteriskLocators.put("telephone", telephoneForAsteriskAtEdit);
        return asteriskLocators;
    }

    public void changeFirstNameAtEditAccount(String firstName) {
        firstNameAtEditAccount.clear();
        firstNameAtEditAccount.sendKeys(firstName);
    }

    public void clickContinueAtEditAccount() {
        buttonContinueAtEditAccount.click();
    }

    public void changeLastNameAtEditAccount(String lastName) {
        lastNameAtEditAccount.clear();
        lastNameAtEditAccount.sendKeys(lastName);
    }
}