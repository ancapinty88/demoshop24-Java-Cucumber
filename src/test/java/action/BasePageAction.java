package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

public class BasePageAction {
    private WebDriver driver;
    public BasePageAction() {
        this.driver = Hooks.driver;
    }

    private WebDriverWait wait;

    private ConfigFileReader reader;


}
