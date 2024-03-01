package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.ConfigFileReader;
import utils.Helper;

public class HomeSteps {


    WebDriver driver;
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

