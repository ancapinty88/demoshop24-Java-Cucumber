package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RegisterAccount_PO {
    @FindBy(how = How.XPATH, using = "//*[@type='checkbox' and @name='agree']")
    private WebElement PolicyCheckbox;
    @FindBy(how = How.XPATH, using = "//div[@id='content']/h1")
    private WebElement ConfirmationHeader;
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Subscribe')]")
    public WebElement Subscribe;
    @FindBy(how = How.XPATH, using = "//*[@class='radio-inline']/*[@type='radio' and @value='1']")
    public WebElement SubscribeYes;
    @FindBy(how = How.XPATH, using = "//*[@class='radio-inline']/*[@type='radio' and @value='0']")
    public WebElement SubscribeNo;



    public String RegistrationConfirmPage() {
        return "http://www.demoshop24.com/index.php?route=account/success";
    }

    public void tickPolicyCheckbox () {
        PolicyCheckbox.click();
    }

    public String readConfirmationHeader () {
        return ConfirmationHeader.getText();
    }

}
