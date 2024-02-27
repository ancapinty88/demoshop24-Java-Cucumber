package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Hooks {
    public static WebDriver driver;
    static String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;


    @Before
    public void openBrowser() throws MalformedURLException {
        if (System.getProperty("os.name").contains("Mac") || System.getProperty("os.name").contains("mac"))
            System.setProperty("webdriver.edge.driver", libWithDriversLocation + "edgedriver");
        else
            System.setProperty("webdriver.edge.driver", libWithDriversLocation + "msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.manage().window().maximize();

        //while certificate is not available
//        driver.findElement(By.cssSelector(".interstitial-wrapper .nav-wrapper #details-button")).click();
//        driver.findElement(By.cssSelector("#final-paragraph #proceed-link")).click();
    }
//    @Before
//    public void openBrowser() throws MalformedURLException {
//        if (System.getProperty("os.name").contains("Mac") || System.getProperty("os.name").contains("mac"))
//            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
//        else
//            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--remote-allow-origins=*");
////        options.addArguments("--ignore-certificate-errors");
////        options.addArguments("--ignore-ssl-errors");
//        driver = new ChromeDriver();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.demoshop24.com/");
//        driver.manage().window().maximize();
//
//    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.log("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }
}
