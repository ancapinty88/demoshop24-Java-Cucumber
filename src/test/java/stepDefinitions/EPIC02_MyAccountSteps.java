package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages_sample.EPIC02MyAccountPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EPIC02_MyAccountSteps extends CommonSteps {

    @Then("user sees My Account links")
    public void userSeesMyAccountLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.myAccountLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.myAccountLinks.get(i).getText());
        }
    }

    @Then("user sees My Orders links")
    public void userSeesMyOrdersLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.myOrdersLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.myOrdersLinks.get(i).getText());
        }
    }

    @Then("user sees My Affiliate Account links")
    public void userSeesMyAffiliateAccountLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.myAffiliateAccountLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.myAffiliateAccountLinks.get(i).getText());
        }
    }

    @And("user sees Newsletter links")
    public void userSeesNewsletterLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.newsletterLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.newsletterLinks.get(i).getText());
        }
    }
}