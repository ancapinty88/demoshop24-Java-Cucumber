package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EPIC02MyAccountPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Account')]/following-sibling::ul[1]")
    public WebElement myAccountBlock;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Orders')]/following-sibling::ul[1]")
    public WebElement myOrdersBlock;
    @FindBy(how = How.CSS, using = ".list-unstyled [href*='route=account/edit']")
    public WebElement editAccountInfoLink;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Account')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> myAccountLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Orders')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> myOrdersLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Affiliate Account')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> myAffiliateAccountLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Newsletter')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> newsletterLinks;
    @FindBy(how = How.CSS, using = "#column-right .list-group a")
    public static List<WebElement> rightMenuLinks;
    @FindBy(how = How.CSS, using = "#column-right .list-group [href*='route=account/edit']")
    public static WebElement editAccountBtnMenuRight;
    @FindBy(how = How.TAG_NAME, using = "legend")
    public static WebElement myAccountPageSubtitle;

    public static void clickEditAccountBtnMenuRight() {
        editAccountBtnMenuRight.click();
    }


}