package pages;

import utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


//only locators
public class HomePage extends BasePage {
    WebDriver driver;
    ConfigFileReader configFileReader;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

//    public HomePage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        configFileReader= new ConfigFileReader();
//    }

    //elements:



}





