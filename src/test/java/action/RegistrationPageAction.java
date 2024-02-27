package action;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.RegistrationPage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static stepDefinitions.Hooks.driver;
import static utils.Helper.clickElement;

public class RegistrationPageAction extends BasePage {

    static WebDriver driver;
    static ConfigFileReader configFileReader;

    public RegistrationPageAction() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();}


//
//
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
//        public void enterFirstName(String firstname) {
//        waitForElementToBePresent(firstNameElement);
//        firstNameElement.sendKeys(firstname);
//    }
//
//    public void enterLastName(String lastname) {
//        waitForElementToBePresent(secondNameElement);
//        secondNameElement.sendKeys(lastname);
//    }
//
//    public void enterEmail(String email) {
//        waitForElementToBePresent(emailElement);
//        emailElement.sendKeys(email);
//
//    }
}



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
