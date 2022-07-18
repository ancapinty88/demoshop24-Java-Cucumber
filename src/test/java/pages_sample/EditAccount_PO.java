package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditAccount_PO {
    @FindBy(how = How.XPATH, using = "//*[@id='content']/h1")
    public WebElement Title;
    @FindBy(how = How.XPATH, using = "//*[@id='content']//legend")
    public WebElement Subtitle;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Back')]")
    public WebElement BackButton;

    public void clickBackButton () {
        BackButton.click();
    }

}
