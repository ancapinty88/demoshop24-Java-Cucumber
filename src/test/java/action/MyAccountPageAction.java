package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.MyAccountPage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

import java.util.List;

public class MyAccountPageAction extends BasePage {
    static WebDriver driver;
    static ConfigFileReader configFileReader;
    static MyAccountPage myAccountPage;

    public MyAccountPageAction() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        myAccountPage = new MyAccountPage();
    }

    public List<WebElement> myAccountLeftSideBlocksLinks(WebDriver driver) {
        int i = 1;
        WebElement element2 = driver.findElement(By.xpath("//div[@id='content']/ul[3]/li/a[@href]"));
        WebElement element3 = driver.findElement(By.xpath("//div[@id='content']/ul[4]/li/a[@href]"));
        for (WebElement element : myAccountPage.getMyAccountBlockLinks()) {
            element = driver.findElement(By.xpath("//div[@id='content']/ul[1]/li[" + i + "]/a[@href]"));
            WebElement element1 = driver.findElement(By.xpath("//div[@id='content']/ul[2]/li[" + i + "]/a[@href]"));
            myAccountPage.getAllMyAccountLeftSideBlocksLinks().add(element);
            myAccountPage.getAllMyAccountLeftSideBlocksLinks().add(element1);
            i++;
        }
        myAccountPage.getAllMyAccountLeftSideBlocksLinks().add(element2);
        myAccountPage.getAllMyAccountLeftSideBlocksLinks().add(element3);
        return myAccountPage.getAllMyAccountLeftSideBlocksLinks();
    }

    public List<WebElement> myAccountRightSideSubMenuLinks(WebDriver driver) {
        int i = 1;
        for (WebElement element : myAccountPage.getSubMenuElementsList()) {
            element = driver.findElement(By.xpath("//aside[@id='column-right']/div/a[ " + i + "]"));
            myAccountPage.getSubMenuElementsList().add(element);
        }

        return myAccountPage.getSubMenuElementsList();
    }

    public List<WebElement> myAccountMenuBlocksOnLeftSideHedersList(WebDriver driver) {
        int i = 1;
        for (WebElement element : myAccountPage.getMyAccountMenuBlocksOnLeftSideHedersList()) {
            element = driver.findElement(By.xpath("//div[@id='content']/h2[ " + i + "]"));
            myAccountPage.getMyAccountMenuBlocksOnLeftSideHedersList().add(element);
        }

        return myAccountPage.getMyAccountMenuBlocksOnLeftSideHedersList();
    }


}
