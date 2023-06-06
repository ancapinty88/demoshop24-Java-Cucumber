package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.BasePage;
import pages_sample.EPIC01RegistrationPage;
import pages_sample.EPIC02MyAccountPage;

public class CommonSteps {
    public WebDriver driver;
    public EPIC01RegistrationPage epic01RegistrationPage;
    public EPIC02MyAccountPage epic02MyAccountPage;
    public BasePage basePage;
    public CommonSteps() {
        this.driver = Hooks.driver;
        this.epic01RegistrationPage = PageFactory.initElements(Hooks.driver, EPIC01RegistrationPage.class);
        this.epic02MyAccountPage = PageFactory.initElements(Hooks.driver, EPIC02MyAccountPage.class);
        this.basePage = PageFactory.initElements(Hooks.driver, BasePage.class);
    }
}
