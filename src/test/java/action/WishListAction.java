package action;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.EditAccountPage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

@Getter
@Setter
public class WishListAction extends BasePage {
    static WebDriver driver;
    static ConfigFileReader configFileReader;
    EditAccountPage editAccountPage;

    public WishListAction() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        editAccountPage = new EditAccountPage();
    }

}
