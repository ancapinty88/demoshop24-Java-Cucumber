package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleSteps {
    private WebDriver driver;
    static HomePage homePage;

    public SampleSteps() {
        this.driver = Hooks.driver;
        homePage = PageFactory.initElements(Hooks.driver, HomePage.class);
    }

    @Given("^I navigated to \"(.*)\" webshop")
    public void iNavigatedToWebShop(String url) {
        driver.navigate().to(url);
    }

    @And("I see {string} title")
    public void iSeeTitle(String titleExpected) {
        String titleActual = driver.getTitle();
        assertEquals(titleExpected,titleActual);
    }
}
