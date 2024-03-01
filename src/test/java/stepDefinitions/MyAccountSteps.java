package stepDefinitions;

import action.BasePageAction;
import action.LoginPageAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.Helper;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyAccountSteps {
    WebDriver driver;
    public static MyAccountPage myAccountPage;
    BasePageAction basePageAction;
    BasePage basePage;
    LoginPage loginPage;
    LoginPageAction loginPageAction;

    public MyAccountSteps() {
        this.driver = Hooks.driver;
        myAccountPage = PageFactory.initElements(Hooks.driver, MyAccountPage.class);
        basePageAction = PageFactory.initElements(Hooks.driver, BasePageAction.class);
        basePage = PageFactory.initElements(Hooks.driver, BasePage.class);
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        loginPageAction = PageFactory.initElements(Hooks.driver, LoginPageAction.class);
    }

    @Then("user see sub menu on the right side of the page")
    public void userSeeSubMenuOnTheRightSideOfThePage() {

    }

    @Then("user login with valid credentials")
    public void userLoginWithValidCredentials(Map<String, String> valuesToEnter) throws InterruptedException {
        basePageAction.enterRandomEmail(valuesToEnter.get("E-Mail Address"), "@email.com", loginPage.getEMailAddressInput(), "email");
        basePageAction.enterRandomString(valuesToEnter.get("Password"), "random", loginPage.getPasswordInputField(), "password");
}

    @Then("user see {string} section on the left side of the page")
    public void userSeeSectionOnTheLeftSideOfThePage(String name) {
        for (WebElement element: myAccountPage.myAccountMenuBlocksOnLeftSideHedersList(driver)) {
            if (element.getText().equals(name)){
                assertEquals(name, element.getText());
                break;
            }

        }
}

    @When("user click on {string} link below the section")
    public void userClickOnLinkBelowTheSection(String link) {
        for (WebElement element: myAccountPage.myAccountLeftSideBlocksLinks(driver)) {
            if (element.getText().equals(link)){
                Helper.clickGivenElement(driver, element);
                break;
            }

        }

    }


}
