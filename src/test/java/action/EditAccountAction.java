package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.EditAccountPage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

public class EditAccountAction extends BasePage {
    static WebDriver driver;
    static ConfigFileReader configFileReader;
    EditAccountPage editAccountPage;

    public EditAccountAction() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        editAccountPage = new EditAccountPage();
    }
}
