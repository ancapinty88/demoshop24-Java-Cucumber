package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.HomePage;
import pages_sample.LoginPage;
import pages_sample.RegistrationPage;

import static stepDefinitions.Hooks.driver;

public class HomeSteps {


    private WebDriver driver;
    public static HomePage homePage;

    public HomeSteps() {
        this.driver = Hooks.driver;
        homePage = PageFactory.initElements(Hooks.driver, HomePage.class);
    }
    @Given("open home page")
    public void openHomePage() {
        driver.get(homePage.getHomePageUrl());
        homePage.verifyThatUserIsOnHomePage();
    }
}
