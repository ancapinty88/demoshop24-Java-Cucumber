package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EPIC02MyAccountPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Account')]/following-sibling::ul[1]")
    public WebElement MyAccountBlock;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Orders')]/following-sibling::ul[1]")
    public WebElement MyOrdersBlock;
    @FindBy(how = How.CSS, using = ".list-unstyled [href*='route=account/edit']")
    public WebElement EditAccountInfoLink;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Account')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> MyAccountLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Orders')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> MyOrdersLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Affiliate Account')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> MyAffiliateAccountLinks;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Newsletter')]/following-sibling::ul[1]//a[@href]")
    public static List<WebElement> NewsletterLinks;

}