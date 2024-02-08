package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps {

    private WebDriver driver;
    static RegistrationPage registrationPage;

    public RegistrationSteps() {
        this.driver = Hooks.driver;
        registrationPage = PageFactory.initElements(Hooks.driver, RegistrationPage.class);
    }




    @And("check that navigation header bar is visible with following icons: valuta, contact, my account, wish list, shopping cart, checkout")
    public void checkThatNavigationHeaderBarIsVisibleWithFollowingIconsValutaContactMyAccountWishListShoppingCartCheckout() {
        registrationPage.navigationHeaderBarIsVisible();
        registrationPage.valutaIconIsVisible();
        registrationPage.contactIconIsVisible();
        registrationPage.myAccountIconIsVisible();
        registrationPage.wishListIconIsVisible();
        registrationPage.shoppingCartIconIsVisible();
        registrationPage.checkoutIconIsVisible();

    }

    @And("click on My account icon on the navigation header bar")
    public void clickClickOnMyAccountIconOnTheNavigationHeaderBar() {
        registrationPage.clickMyAccountIcon();
    }

    @And("Click on Register option from My account menu")
    public void clickOnRegisterOptionFromMyAccountMenu() {
        registrationPage.clickRegisterOption();
    }

    @Then("user is redirected to Register Account page")
    public void userIsRedirectedToRegisterAccountPage() {
        driver.get(RegistrationPage.getRegistrationPageUrl());
        RegistrationPage.verifyThatUserIsOnRegistrationPage();
    }

    @Then("Fill all input fields in register account page {string} {string} {string}{string} {string} {string} {string}:")
    public void fillAllInputFieldsInRegisterAccountPage(String firstname , String lastname, String email,
                                                        String telephone, String password, String confirmpassword, String subscribe) throws InterruptedException{
        registrationPage.enterFirstName(firstname);
        registrationPage.enterLastName(lastname);
        registrationPage.enterEmail(email);
        //registrationPage.enterEmail("testuser" + System.currentTimeMillis() + "@example.com");
        registrationPage.enterTelephone(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        registrationPage.enterPassword(password);
        Thread.sleep(1000);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmpassword);
        registrationPage.confirmPassword(confirmpassword);
        Thread.sleep(1000);
        registrationPage.radiobuttonsubscribe(subscribe);
        Thread.sleep(1000);
    }
    @And("Click on I have read and agree to the Privacy Policy checkbox")
    public void clickOnIHaveReadAndAgreeToThePrivacyPolicyCheckbox() {
        registrationPage.checkboxAgree();
    }

    @Then("Click the Continue button")
    public void clickTheContinueButton() throws InterruptedException {
        registrationPage.continueButton();
        Thread.sleep(1000);

    }
    @Then("Assert and check the page")
    public void assertAndCheckThePage() {
        String currentURL = driver.getCurrentUrl();
        assertEquals("https://www.demoshop24.com/index.php?route=account/success", currentURL);
    }



}
