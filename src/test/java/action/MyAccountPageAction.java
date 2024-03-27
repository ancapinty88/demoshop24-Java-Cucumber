package action;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    }

    public List<WebElement> myAccountLeftSideBlocksLinks(WebDriver driver) {
            List<WebElement> allMyAccountLeftSideBlocksLinks = new ArrayList<>();
            int maxIndex = 4; //the maximum index is 4
            for (int i = 1; i <= maxIndex; i++) {
                List<WebElement> elements = myAccountPage.getMyAccountLinks(i);
                allMyAccountLeftSideBlocksLinks.addAll(elements);
            }
            return allMyAccountLeftSideBlocksLinks;
        }

//        int i = 1;
//        WebElement element2 = driver.findElement(By.xpath("//div[@id='content']/ul[3]/li/a[@href]"));
//        WebElement element3 = driver.findElement(By.xpath("//div[@id='content']/ul[4]/li/a[@href]"));
//        for (WebElement element : myAccountPage.getMyAccountBlockLinks()) {
//            element = driver.findElement(By.xpath("//div[@id='content']/ul[1]/li[" + i + "]/a[@href]"));
//            WebElement element1 = driver.findElement(By.xpath("//div[@id='content']/ul[2]/li[" + i + "]/a[@href]"));
//            myAccountPage.getAllMyAccountLeftSideBlocksLinks().add(element);
//            myAccountPage.getAllMyAccountLeftSideBlocksLinks().add(element1);
//            i++;
//        }
//        myAccountPage.getAllMyAccountLeftSideBlocksLinks().add(element2);
//        myAccountPage.getAllMyAccountLeftSideBlocksLinks().add(element3);
//        return myAccountPage.getAllMyAccountLeftSideBlocksLinks();


    public List<WebElement> findElementsWithIndexedXPath(WebDriver driver, String baseXPath, List<WebElement> elementsList) {
        int i = 1;
        for (WebElement element : elementsList) {
            element = driver.findElement(By.xpath(baseXPath + "[" + i + "]"));
            elementsList.add(element);
            i++;
        }
        return elementsList;
    }

    public List<WebElement> myAccountRightSideSubMenuLinks(WebDriver driver) {
        String baseXPath = "//aside[@id='column-right']/div/a";
        List<WebElement> subMenuElementsList = myAccountPage.getSubMenuElementsList();
        return findElementsWithIndexedXPath(driver, baseXPath, subMenuElementsList);
    }

    public List<WebElement> myAccountMenuBlocksOnLeftSideHedersList(WebDriver driver) {
        String baseXPath = "//div[@id='content']/h2";
        List<WebElement> menuBlocksList = myAccountPage.getMyAccountMenuBlocksOnLeftSideHedersList();
        return findElementsWithIndexedXPath(driver, baseXPath, menuBlocksList);
    }
}


