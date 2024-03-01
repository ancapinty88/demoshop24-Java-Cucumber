package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.MyAccountPage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;


public class MyAccountPageAction extends BasePage {
    static WebDriver driver;
    static ConfigFileReader configFileReader;
    static MyAccountPage myAccountPage;

    public MyAccountPageAction() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        myAccountPage = new MyAccountPage();

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
