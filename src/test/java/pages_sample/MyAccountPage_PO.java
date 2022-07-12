package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage_PO {
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Edit your account information')]")
    public WebElement LinkEditYourAccountInfo;
    @FindBy(how = How.XPATH, using = "//h2")
    public List<WebElement> MyAccountHeaders;

    public List<String> getMyAccountHeaderstext (List<WebElement> list) {
        List<String> MyAccHeaders = new ArrayList<>();
        for (WebElement l : list) {
            String header = l.getText();
            MyAccHeaders.add(header);
        }
        return MyAccHeaders;
    }

}
