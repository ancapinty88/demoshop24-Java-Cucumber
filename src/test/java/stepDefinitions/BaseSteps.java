package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.ConfigFileReader;
import utils.Helper;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    WebDriver driver;
    ConfigFileReader configFileReader;
    Helper helper;

    //constructor
    public static BasePage basePage;

    public BaseSteps(){
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
        this.basePage = new BasePage();
        helper = new Helper();
    }
//    @Then("Click on Login from My Account menu")
//    public void clickOnLoginFromMyAccountMenu() {
//        //clickLoginOption();
//        clickElement(basePage.getLoginOption());
//    }

    @Given("user navigates to home page")
    public void userNavigatesToHomePage() {
    configFileReader.getHomePageUrl();
    }

    @When("user clicks {string} button")
    public void userClicksButton(String button) {
//pass web element
        basePage.clickMyAccountMenu(button);
//click method

//pass string text

    }

    @When("user is on {string} page")
    public void userIsOnPage(String PageName) {
        String pageURL = configFileReader.getConfigVariable(PageName);
        helper.navigateToUrl(pageURL);
        //helper.assertElementIsDisplayed(basePage.TDStext);

    }

    @Then("navigation header bar icons are displayed")
    public void navigationHeaderBarIconsAreDisplayed() {
    basePage.getIconElements();


    }

    @And("{string} is displayed")
    public void isDisplayed(String text) {
        helper.assertElementIsDisplayed(basePage.TDStext);
    }
}
