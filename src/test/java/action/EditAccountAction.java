package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.EditAccountPage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    public void checkIfInputValueIsPresent(String text, WebElement element) {

        String typedText = element.getAttribute("value");
        if (typedText.equals(text)) {

            assertEquals(text,  typedText);
        }
    }
}
