package stepDefinitions;

import pages.HomePage;
import utils.Helper;
import action.HomePageAction;
import utils.ConfigFileReader;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static action.HomePageAction.navigateTo_HomePage;

public class HomeSteps {


    private WebDriver driver;
    public static HomePage homePage;

    ConfigFileReader configFileReader;
    Helper helper;

    public HomeSteps() {
        this.driver = Hooks.driver;
        homePage = PageFactory.initElements(Hooks.driver, HomePage.class);
    }

//    @Given("open home page")
//    public void openHomePage() {
//        configFileReader= new ConfigFileReader();
//        System.setProperty("webdriver.edge.driver", configFileReader.getDriverPath());
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
//        //homePage = helper.getHomePage();
//        HomePageAction.navigateTo_HomePage();
//        HomePageAction.verifyThatUserIsOnHomePage();
//    }

}

