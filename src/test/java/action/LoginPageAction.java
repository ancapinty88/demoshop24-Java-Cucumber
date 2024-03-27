package action;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.LoginPage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageAction extends BasePage {

    static WebDriver driver;
    static ConfigFileReader configFileReader;
    static LoginPage loginPage;


    public LoginPageAction() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        loginPage = new LoginPage();

    }

    public void verifyThatUserIsOnLoginPage() {
        String expectedUrl = configFileReader.getLoginPageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }


    public void enterEmailLogin(String email, WebElement emailLogin) {
        waitForElementToBePresent(emailLogin);
        emailLogin.sendKeys(email);
    }

    public void waitForElementToBePresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)); //common
    }

    public void enterPasswordLogin(String password, WebElement passwordLogin) {
        waitForElementToBePresent(passwordLogin);
        passwordLogin.sendKeys(password);
    }

//    public void clickLoginButton(WebElement element) {
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        clickElement((By) loginPage.getLogInButtonInLoginForm());
//
//
//    }


//    public static void myAccountSectionIsVisible(WebElement myAccountSection) {
//
//        assertTrue(myAccountSection.isDisplayed());//common
//    }
//
//    public static void myOrdersSectionIsVisible(WebElement myOrdersSection) {
//        assertTrue(myOrdersSection.isDisplayed());
//    }
//
//    public static void myAffiliateAccountSectionIsVisible(WebElement myAffiliateAccountSection) {
//        assertTrue(myAffiliateAccountSection.isDisplayed());
//    }
//
//    public static void newsletterSectionIsVisible(WebElement newsletterSection) {
//        assertTrue(newsletterSection.isDisplayed());
//    }
//
}
