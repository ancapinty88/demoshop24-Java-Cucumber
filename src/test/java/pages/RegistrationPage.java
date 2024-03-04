package pages;

import java.util.*;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



//only locators
@Getter
@Setter
public class RegistrationPage extends BasePage {

    //elements:

    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-email")
    private WebElement emailAddressInput;
    @FindBy(id = "input-telephone")
    private WebElement telephoneNumberInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmInput;
    @FindBy(css = "input[name='newsletter'][checked='checked']")
    private WebElement radioButtonNoOption;
    @FindBy(name = "agree")
    private WebElement checkboxToAgreeWithPrivacyPolicy;
    @FindBy(css = "input[value='Continue']")
    private WebElement continueButtonInRegistrationField;
    @FindBy(css = ".dropdown a i")
    private WebElement myAccountDropdown;
    @FindBy(xpath = "//li[@class='dropdown open']/ul/li[1]/a")
    private WebElement registerLink;
    @FindBy(css = ".form-group.required")
    private List<WebElement> requiredFieldElements;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement alertMessage;


//    public static String getRegistrationPageUrl() {
//        return "https://www.demoshop24.com/index.php?route=account/register";
//    }
//
//    public static void verifyThatUserIsOnRegistrationPage() {
//
//        String expectedUrl = RegistrationPage.getRegistrationPageUrl();
//        assertEquals(expectedUrl, driver.getCurrentUrl());
//    }

//    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
//    private WebElement registerOption;
//
//    @FindBy(xpath = "//li[@class='dropdown open']/ul/li[1]/a")
//    private WebElement registerLink;
//
//    @FindBy(how = How.ID, using = "input-firstname")
//    private WebElement firstNameElement;
//
//    @FindBy(how = How.ID, using = "input-lastname")
//    private WebElement secondNameElement;
//
//    @FindBy(how = How.ID, using = "input-email")
//    private WebElement emailElement;
//
//    @FindBy(how = How.ID, using = "input-telephone")
//    private WebElement telephoneElement;
//
//    @FindBy(how = How.ID, using = "input-password")
//    private WebElement passwordElement;
//
//    @FindBy(how = How.ID, using = "input-confirm")
//    private WebElement confirmPasswordElement;
//
//    @FindBy(css = ".form-group.required")
//    private List<WebElement> requiredFieldElements;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
//    private WebElement subscribeYesLocator;
//
//    @FindBy(css = "input[name='newsletter'][checked='checked']")
//    private WebElement subscribeNoLocator;
//
//    @FindBy(how = How.NAME, using = "agree")
//    private WebElement checkBoxElement;
//
//    @FindBy(how = How.CSS, using = "input[value='Continue']")
//    private WebElement continueElement;
//
//    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger alert-dismissible']")
//    private WebElement warningRegMsg;


//    public void emailErrorMessage(String eMail) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        assertEquals("Please include an '@' in the email address. '"+emailElement.getAttribute("value")+"' is missing an '@'.", message);
//
//    }

//    //method:
//    public void navigationHeaderBarIsVisible() {
//        assertTrue(headerNavigationBar.isDisplayed());
//    }
//
//    public void valutaIconIsVisible() {
//        assertTrue(valutaIcon.isDisplayed());
//    }
//
//
//    public void contactIconIsVisible() {
//        assertTrue(contactIcon.isDisplayed());
//    }
//
//    public void myAccountIconIsVisible() {
//        assertTrue(myAccountIcon.isDisplayed());
//    }
//
//    public void wishListIconIsVisible() {
//        assertTrue(wishListIcon.isDisplayed());
//    }
//
//    public void shoppingCartIconIsVisible() {
//        assertTrue(shoppingCartIcon.isDisplayed());
//    }
//
//    public void checkoutIconIsVisible() {
//        assertTrue(contactIcon.isDisplayed());
//    }
//
//
//    public static WebDriverWait wait;
//
//    public void clickMyAccountIcon() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(myAccountIcon));
//        clickElement(myAccountIcon);
//    }
//
//    public void clickRegisterOption() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(registerOption));
//        clickElement(registerOption);
//    }
//
//    private void waitForElementToBePresent(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public void enterFirstName(String firstname) {
//        waitForElementToBePresent(firstNameElement);
//        firstNameElement.sendKeys(firstname);
//    }
//
//    public void enterLastName(String lastname) {
//        waitForElementToBePresent(secondNameElement);
//        secondNameElement.sendKeys(lastname);
//    }
//
//
//    public void enterEmail(String email) {
//        waitForElementToBePresent(emailElement);
//        emailElement.sendKeys(email);
//
//    }
//
//    public void enterTelephone(String telephone) {
//        telephoneElement.sendKeys(telephone);
//    }
//
//    public void enterPassword(String password) {
//        passwordElement.clear();
//        passwordElement.sendKeys(password);
//    }
//
//
//    public void confirmPassword(String confirmpassword) {
//        confirmPasswordElement.clear();
//        confirmPasswordElement.sendKeys(confirmpassword);
//    }
//
//    public void radiobuttonsubscribe(String subscribe) {
//        WebElement subscribeYesRadio = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input"));
//        WebElement subscribeNoRadio = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input"));
//        // String subscribe = null;
//        if ("Yes".equalsIgnoreCase(subscribe)) {
//            if (!subscribeYesRadio.isSelected()) {
//                subscribeYesRadio.click();
//            }
//        } else {
//            if (!subscribeNoRadio.isSelected()) {
//                subscribeNoRadio.click();
//            }
//        }
//    }
//
//    public void checkboxAgree() {
//        checkBoxElement.click();
//    }
//
//    public void continueButton() {
//        //WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.elementToBeClickable(continueElement));
//        clickElement(continueElement);
//    }
//
//    public void assertEmailError() {
//        assertEquals("Warning: E-Mail Address is already registered!",
//                driver.findElement(By.cssSelector("#account-register > div.alert.alert-danger.alert-dismissible")).getText());
//    }
//
//    public void assertPasswordError() {
//        assertEquals("Password must be between 4 and 20 characters!",
//                driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText());
//    }
//
//    public void assertPasswordLengthError() {
//        try {
//
//            WebElement parentElement = confirmPasswordElement.findElement(By.xpath(".."));
//            assertEquals("Password must be between 4 and 20 characters!",
//                    parentElement.findElement(By.className("text-danger")).getText());
//
//        } catch (Exception e) {
//
//            System.out.println("Expected Result: Registration fails, the user should receive relevant error message." +
//                    "Actual Result : Registration success");
//            //  throw new RuntimeException("No Error Element");
//            assertFalse(true);
//
//        }
//    }
//
//    public void phonenumberErrorMessage() {
//        try {
//
//            WebElement parentElement = telephoneElement.findElement(By.xpath(".."));
//            assertEquals("Telephone must be between 3 and 32 characters!",
//                    parentElement.findElement(By.className("text-danger")).getText());
//
//        } catch (Exception e) {
//
//            System.out.println("Expected Result: Registration fails, the user should receive relevant error message." +
//
//                    "Actual Result : Registration success");
//            //  throw new RuntimeException("No Error Element");
//            assertFalse(true);
//
//        }
//
//    }
//
//
//    public void uncheckprivacypolicy() {
//        checkBoxElement.click();
//    }
//
//    public void privacyPolicyErrorMessage() {
//        assertEquals("Warning: You must agree to the Privacy Policy!",
//                driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText());
//    }
//}


}
