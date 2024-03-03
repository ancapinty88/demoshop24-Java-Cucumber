package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.MyAccountPage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordPageAction extends BasePage {
    static WebDriver driver;
    static ConfigFileReader configFileReader;
    static MyAccountPage myAccountPage;

    public PasswordPageAction() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        myAccountPage = new MyAccountPage();
    }

    //new Explicit Wait function to wait until web element is present
    public void WaitFunction(WebDriver webDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_DURATION);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    // updated click event function implementing Explicit Wait
    public void getClickEvent(WebDriver de, WebElement element) {
        WaitFunction(de, element);
        element.click();
    }


    //method for success message because of enormous white spaces in the text
    public void compareSuccessMessage(WebElement name, String element) {
        String title = name.getText();
        String result = title.replaceAll("\\h*\\R+\\h*", " ").trim();
        String finalResult = result.replaceAll("[^a-zA-Z0-9:!?*]", " ").trim();
        assertEquals(element, finalResult);
        // int index = title.indexOf("!");
        // String title1 = result.substring(0, index+1);
    }

    public void getStepsTitlesCompare(WebElement name, String element) {
        String title = name.getText();
        String result = title.replaceAll("Step", " ").trim();
        String finalResult = result.replaceAll("[^a-zA-Z]", " ").trim();
        assertEquals(element, finalResult);
    }

    public String getElementLabel(WebElement inputField) {
        WebElement label = inputField.findElement(By.tagName("label"));
        return label.getText();
    }

    public String getElementErrorMessage(WebElement inputField) {
        WebElement error = inputField.findElement(By.cssSelector(".text-danger"));
        return error.getText();
    }

    public String getValidationErrorMessage(WebDriver webDriver, WebElement inputField) {
        String errorValidationMessage = new WebDriverWait(webDriver, TIMEOUT_DURATION).until(ExpectedConditions.elementToBeClickable(inputField)).getAttribute("validationMessage");
        return errorValidationMessage;

    }

    public static final Duration TIMEOUT_DURATION = Duration.ofSeconds(40);

    public void enterDataToTheInputField(WebElement element, String text) {
        element.sendKeys(text);
    }

    public List<String> getMandatoryFields(List<WebElement> requiredElements) {
        List<String> mandatoryFields = new ArrayList<>();
        for (WebElement element : requiredElements) {
            if (!element.getAttribute("style").contains("display: none")) {
                mandatoryFields.add(getElementLabel(element));
            }
        }
        return mandatoryFields;
    }

    public List<String> getMandatoryTableFields(List<WebElement> requiredElements) {
        List<String> mandatoryFields = new ArrayList<>();
        for (WebElement element : requiredElements) {
            if (!element.getAttribute("style").contains("display: none")) {
                mandatoryFields.add(getTableText(element));
            }
        }
        return mandatoryFields;
    }

    public String getTableText(WebElement inputField) {
        WebElement label = inputField;
        return label.getText();
    }


}