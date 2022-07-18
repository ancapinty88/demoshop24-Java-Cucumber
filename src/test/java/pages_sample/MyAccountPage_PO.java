package pages_sample;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage_PO {
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Edit your account information')]")
    public WebElement LinkEditYourAccountInfo;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Edit Account')]")
    public WebElement EditAccount;
    @FindBy(how = How.XPATH, using = "//h2")
    public List<WebElement> MyAccountHeaders;

    public void clickEditAccount () {
        EditAccount.click();
    }


}
