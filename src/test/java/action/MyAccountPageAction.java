package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyAccountPageAction extends BasePage {
    static WebDriver driver;
    static ConfigFileReader configFileReader;

    public MyAccountPageAction() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();

//    public void navigateTo_MyAccountPage() {
//    driver.get(configFileReader.getMyAccountPageUrl());
//    }
//
//    public void verifyThatUserIsOnMyAccountPage() {
//    String expectedUrl = configFileReader.getMyAccountPageUrl();
//    assertEquals(expectedUrl, driver.getCurrentUrl());
//    }

    }
}
