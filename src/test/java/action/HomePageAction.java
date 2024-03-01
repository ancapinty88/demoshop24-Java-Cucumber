package action;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;


public class HomePageAction extends BasePage {
    static WebDriver driver;
    static ConfigFileReader configFileReader;

    public HomePageAction(WebDriver driver) {
        this.driver = Hooks.driver;
    }

//    public static String getHomePageUrl() {
//        return "https://www.demoshop24.com/index.php?route=common/home";
//    }

//    public static void navigateTo_HomePage() {
//        driver.get(configFileReader.getHomePageUrl());
//    }


}

