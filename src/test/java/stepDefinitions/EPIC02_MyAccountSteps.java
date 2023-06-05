package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages_sample.EPIC02MyAccountPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EPIC02_MyAccountSteps {
    private final BaseSteps steps;
    public EPIC02_MyAccountSteps(BaseSteps steps) {
        this.steps = new BaseSteps();
    }

    @Then("user sees My Account links")
    public void userSeesMyAccountLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.MyAccountLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.MyAccountLinks.get(i).getText());
        }
    }

    @Then("user sees My Orders links")
    public void userSeesMyOrdersLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.MyOrdersLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.MyOrdersLinks.get(i).getText());
        }
    }

    @Then("user sees My Affiliate Account links")
    public void userSeesMyAffiliateAccountLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.MyAffiliateAccountLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.MyAffiliateAccountLinks.get(i).getText());
        }
    }

    @And("user sees Newsletter links")
    public void userSeesNewsletterLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.NewsletterLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.NewsletterLinks.get(i).getText());
        }
    }
}