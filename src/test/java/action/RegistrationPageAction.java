package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

public class RegistrationPageAction extends BasePage {

    static WebDriver driver;
    static ConfigFileReader configFileReader;

    public RegistrationPageAction() {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }
}