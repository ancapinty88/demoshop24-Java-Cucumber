package action;

import pages.BasePage;
import pages.HomePage;
import utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomePageAction extends BasePage {
    static WebDriver driver;
    static ConfigFileReader configFileReader;

    public HomePageAction(WebDriver driver) {
        this.driver = driver;
    }

//    public static String getHomePageUrl() {
//        return "https://www.demoshop24.com/index.php?route=common/home";
//    }

    public static void verifyThatUserIsOnHomePage() {
        String expectedUrl = configFileReader.getHomePageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public static void navigateTo_HomePage(){
        driver.get(configFileReader.getHomePageUrl());
    }


}

