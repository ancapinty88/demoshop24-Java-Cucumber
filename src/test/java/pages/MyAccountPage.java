package pages;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigFileReader;

@Getter
@Setter
//only locators
public class MyAccountPage extends BasePage {

    public static WebDriver driver;
    ConfigFileReader configFileReader;

    public void MyAccountPagePage() {
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    //elements:

    //right menu
    @FindBy(id = "column-right")
    private WebElement rightSideSubMenuInMyAccount;

    @FindBy(xpath = "//aside[@id='column-right']/div/a[@href]")
    private List<WebElement> subMenuElementsList;

    //left menu
    @FindBy(xpath = "//div[@id='content']/h2")
    private List<WebElement> myAccountMenuBlocksOnLeftSideHedersList;
//    @FindBy(xpath = "//div[@id='content']/ul[1]/li/a[@href]")
//    private List<WebElement> myAccountBlockLinks;
//    @FindBy(xpath = "//div[@id='content']/ul[2]/li/a[@href]")
//    private List<WebElement> myOrdersBlockLinks;
//    @FindBy(xpath = "//div[@id='content']/ul[3]/li/a[@href]")
//    private List<WebElement> myAffiliateAccountBlockLinks;
//    @FindBy(xpath = "//div[@id='content']/ul[4]/li/a[@href]")
//    private List<WebElement> newsletterBlockLinks;
    @FindBy(xpath = "//div[@id='content']/ul/li/a[@href]")
    private List<WebElement> allMyAccountLeftSideBlocksLinks;

    public List<WebElement> getMyAccountLinks(int index) {
        String xpathMyAccount = "//div[@id='content']/ul[" + index + "]/li/a[@href]";
        return driver.findElements(By.xpath(xpathMyAccount));
    }
}