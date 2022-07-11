package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.HomePage_PO;

public class HomePageSteps {
    private WebDriver driver;
    static HomePage_PO HomePagePO;

    public HomePageSteps() {
        this.driver = Hooks.driver;
        HomePagePO = PageFactory.initElements(Hooks.driver, HomePage_PO.class);
    }

    @Given("^User is on Register Account page$")
    public void userIsOnRegisterAccountPage() throws Throwable {
        driver.get(HomePagePO.homePage());
        HomePagePO.clickMyAccountDropdown();
        HomePagePO.clickMyAccountRegister();
    }

    @Given("^User is on Login page$")
    public void userIsOnLoginPage() throws Throwable {
        driver.get(HomePagePO.homePage());
        HomePagePO.clickMyAccountDropdown();
        HomePagePO.clickMyAccountLogin();
    }

}
