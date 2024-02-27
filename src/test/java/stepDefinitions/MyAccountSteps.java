package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MyAccountPage;

import static action.LoginPageAction.*;


public class MyAccountSteps {
    private WebDriver driver;
    public static MyAccountPage myAccountPage;

    public MyAccountSteps() {
        this.driver = Hooks.driver;
        myAccountPage = PageFactory.initElements(Hooks.driver, MyAccountPage.class);
    }

//    @And("Check that all sections are visible on page")
//    public void checkThatAllSectionsAreVisibleOnPage() {
//        myAccountSectionIsVisible(myAccountPage.getMyAccountSection());
//        myOrdersSectionIsVisible(myAccountPage.getMyOrdersSection());
//        myAffiliateAccountSectionIsVisible(myAccountPage.getMyAffiliateAccountSection());
//        newsletterSectionIsVisible(myAccountPage.getNewsletterSection());
//    }
}
