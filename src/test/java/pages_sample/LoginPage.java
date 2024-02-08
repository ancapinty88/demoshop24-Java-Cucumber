package pages_sample;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages_sample.RegistrationPage.wait;
import static stepDefinitions.Hooks.driver;
import static stepDefinitions.LoginSteps.loginPage;

public class LoginPage {
    public static String getLoginPageUrl(){return "https://www.demoshop24.com/index.php?route=account/login";}

    public static void verifyThatUserIsOnLoginPage() {
        String expectedUrl = LoginPage.getLoginPageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    private static WebElement loginOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[1]")
    private WebElement myAccountSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[2]")
    private WebElement myOrdersSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[3]")
    private WebElement myAffiliateAccountSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[4]")
    private WebElement newsletterSection;

    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailLogin;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordLogin;

    public static void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void clickLoginOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginOption));
        clickElement(loginOption);
    }


    public void enterEmailLogin(String email) {
        waitForElementToBePresent(emailLogin);
        emailLogin.sendKeys(email);
    }

    private void waitForElementToBePresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));}

    public void enterPasswordLogin(String password){
        waitForElementToBePresent(passwordLogin);
        passwordLogin.sendKeys(password);
    }
        public void clickLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        clickElement(loginButton);

    }
    public void myAccountSectionIsVisible(){
        Assertions.assertTrue(myAccountSection.isDisplayed());}
    public void myOrdersSectionIsVisible(){Assertions.assertTrue(myOrdersSection.isDisplayed());}
    public void myAffiliateAccountSectionIsVisible(){Assertions.assertTrue(myAffiliateAccountSection.isDisplayed());}
    public void newsletterSectionIsVisible(){Assertions.assertTrue(newsletterSection.isDisplayed());}

    @And("Check that all sections are visible on page")
    public void checkThatAllSectionsAreVisibleOnPage() {
        loginPage.myAccountSectionIsVisible();
        loginPage.myOrdersSectionIsVisible();
        loginPage.myAffiliateAccountSectionIsVisible();
        loginPage.newsletterSectionIsVisible();
    }

}
