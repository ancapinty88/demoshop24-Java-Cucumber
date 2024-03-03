package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;
import java.util.List;

@Getter
@Setter
//only locators
public class MyAccountPage extends BasePage {

    public static WebDriver driver;
    ConfigFileReader configFileReader;

    public void MyAccountPagePage() {

        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

//    //elements:
    //new locators:

    //right menu
    @FindBy(id = "column-right")
    private WebElement rightSideSubMenuInMyAccount;

    @FindBy(xpath = "//aside[@id='column-right']/div/a[@href]")
    private List<WebElement> subMenuElementsList;
    //
//    //left menu
    @FindBy(xpath = "//div[@id='content']/h2")
    private List<WebElement> myAccountMenuBlocksOnLeftSideHedersList;
    @FindBy(xpath = "//div[@id='content']/ul[1]/li/a[@href]")
    private List<WebElement> myAccountBlockLinks;
    @FindBy(xpath = "//div[@id='content']/ul[2]/li/a[@href]")
    private List<WebElement> myOrdersBlockLinks;
    @FindBy(xpath = "//div[@id='content']/ul[3]/li/a[@href]")
    private List<WebElement> myAffiliateAccountBlockLinks;
    @FindBy(xpath = "//div[@id='content']/ul[4]/li/a[@href]")
    private List<WebElement> newsletterBlockLinks;



    @FindBy(xpath = "//div[@id='content']/ul/li/a[@href]")
    private List<WebElement> allMyAccountLeftSideBlocksLinks;

    public List<WebElement> myAccountLeftSideBlocksLinks(WebDriver driver) {
        int i = 1;
        WebElement element2 = driver.findElement(By.xpath("//div[@id='content']/ul[3]/li/a[@href]"));
        WebElement element3 = driver.findElement(By.xpath("//div[@id='content']/ul[4]/li/a[@href]"));
        for (WebElement element : myAccountBlockLinks) {
            element = driver.findElement(By.xpath("//div[@id='content']/ul[1]/li[" + i + "]/a[@href]"));
            WebElement element1 = driver.findElement(By.xpath("//div[@id='content']/ul[2]/li[" + i + "]/a[@href]"));
            allMyAccountLeftSideBlocksLinks.add(element);
            allMyAccountLeftSideBlocksLinks.add(element1);
            i++;
        }
        allMyAccountLeftSideBlocksLinks.add(element2);
        allMyAccountLeftSideBlocksLinks.add(element3);
        return allMyAccountLeftSideBlocksLinks;
    }

    public List<WebElement> myAccountRightSideSubMenuLinks(WebDriver driver) {
        int i = 1;
        for (WebElement element : subMenuElementsList) {
            element = driver.findElement(By.xpath("//aside[@id='column-right']/div/a[ " + i + "]"));
            subMenuElementsList.add(element);
        }

        return subMenuElementsList;
    }

    public List<WebElement> myAccountMenuBlocksOnLeftSideHedersList(WebDriver driver) {
        int i = 1;
        for (WebElement element : myAccountMenuBlocksOnLeftSideHedersList) {
            element = driver.findElement(By.xpath("//div[@id='content']/h2[ " + i + "]"));
            myAccountMenuBlocksOnLeftSideHedersList.add(element);
        }

        return myAccountMenuBlocksOnLeftSideHedersList;
    }


//    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[1]")
//    private WebElement myAccountSection;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[2]")
//    private WebElement myOrdersSection;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[3]")
//    private WebElement myAffiliateAccountSection;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[4]")
//    private WebElement newsletterSection;
}