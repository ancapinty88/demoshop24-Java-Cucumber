package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.LoginPage_PO;
import pages_sample.MyAccountPage_PO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyAccountPageSteps {
    private WebDriver driver;
    static MyAccountPage_PO MyAccountPagePO;

    public MyAccountPageSteps () {
        this.driver = Hooks.driver;
        MyAccountPagePO = PageFactory.initElements(Hooks.driver, MyAccountPage_PO.class);
    }

    @And("^Link \"([^\"]*)\" is available$")
    public void LinkEditYourAccountInfoIsAvailable (String linkName) {
        assertTrue(MyAccountPagePO.LinkEditYourAccountInfo.isDisplayed());
        assertEquals(linkName, MyAccountPagePO.LinkEditYourAccountInfo.getText());
    }

    @And("^Blocks are presented:$")
    public void BlocksArePresented (List<String> blocks) {
        for (String block : blocks) {
            assertTrue(MyAccountPagePO.getMyAccountHeaderstext(MyAccountPagePO.MyAccountHeaders).contains(block));
        }
    }

}
