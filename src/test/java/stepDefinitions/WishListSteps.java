package stepDefinitions;

import action.*;
import io.cucumber.java.en.*;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.EditAccountPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.PasswordPage;
import pages.WishListPage;
import utils.ConfigFileReader;
import utils.Helper;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter
@Setter

public class WishListSteps extends BasePage {
    WebDriver driver;
    static PasswordPage passwordPage;
    static ConfigFileReader configFileReader;
    LoginPageAction loginPageAction;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyAccountPageAction myAccountPageAction;
    BasePage basePage;
    BasePageAction basePageAction;
    PasswordPageAction passwordPageAction;
    EditAccountPage editAccountPage;
    WishListPage wishListPage;

    public WishListSteps() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        loginPageAction = new LoginPageAction();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        myAccountPageAction = new MyAccountPageAction();
        basePage = new BasePage();
        basePageAction = new BasePageAction();
        passwordPageAction = new PasswordPageAction();
        editAccountPage = new EditAccountPage();
        wishListPage = new WishListPage();
    }

    @When("user clicks {string} button in Wish List page")
    public void userClicksButtonInWishListPage() {
        Helper.clickGivenElement(driver, wishListPage.getWishListContinueButton());
    }

    @Then("user click on Wish List link in navigation header menu")
    public void userClickOnWishListLinkInNavigationHeaderMenu() throws InterruptedException {
        Thread.sleep(1500);
        Helper.clickGivenElement(driver, wishListPage.getWishListTopMenuLink());
    }

    @When("user clicks on Testing Demo Shop logo link")
    public void userClicksOnTestingDemoShopLogoLink() {
        Helper.clickGivenElement(driver, wishListPage.getDemoShopLogoLink());
    }

    @When("user clicks on heart icon under the MacBook item")
    public void userClicksOnHeartIconUnderTheMacBookItem() {
        Helper.clickGivenElement(driver, wishListPage.getAddToWishListButton());
    }

    @Then("user see {string} that product was added")
    public void userSeeThatProductWasAdded(String arg0) {
        basePageAction.compareSuccessMessage(wishListPage.getSuccessMessage(), arg0);
    }

    @When("user clicks on wish list link in success message description")
    public void userClicksOnWishListLinkInSuccessMessageDescription() throws InterruptedException {
        Thread.sleep(1500);
        Helper.clickGivenElement(driver, wishListPage.getWishListLinkInSuccessMessage());
    }

    @And("user clicks on Remove button from Action table field")
    public void userClicksOnRemoveButtonFromActionTableField() {
        Helper.clickGivenElement(driver, wishListPage.getRemoveButtonInTheTable());
    }

    @When("user see table with fields")
    public void userSeeTableWithFields(List<String> tableFields) {
        List<String> requiredTableFields = basePageAction.getMandatoryTableFields(wishListPage.getRequiredTableFields());
        assertEquals(tableFields, requiredTableFields);
    }

    @Then("user click on Add to Cart button in Action table field")
    public void userClickOnAddToCartButtonInActionTableField() {
        Helper.clickGivenElement(driver, wishListPage.getAddToCartButtonInTheTable());
    }

    @Then("user see {string} that Wish list was updated")
    public void userSeeThatWishListWasUpdated(String arg0) {
        basePageAction.compareSuccessMessage(wishListPage.getSuccessMessage(), arg0);
    }
}

