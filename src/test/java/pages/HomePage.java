package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;


//only locators
public class HomePage extends BasePage {
    static WebDriver driver;
    ConfigFileReader configFileReader;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage(WebDriver driver) {

        this.driver =  Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    //elements:



}





