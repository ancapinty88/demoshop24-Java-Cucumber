package pages;

import utils.ConfigFileReader;

import java.time.Duration;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Helper.clickElement;
import static org.junit.jupiter.api.Assertions.*;

@Getter
@Setter
//only locators
public class LoginPage {

    public static WebDriver driver;
    ConfigFileReader configFileReader;

    public LoginPage(WebDriver driver){
        LoginPage.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader= new ConfigFileReader();
    }



    //elements:

    @FindBy(how = How.CSS, using = "input[value='Login']") //edited
    private WebElement loginButton;

    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailLogin;

    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordLogin;



}
