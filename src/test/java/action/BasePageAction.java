package action;

import com.github.javafaker.Faker;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import stepDefinitions.Hooks;
import utils.ConfigFileReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter
@Setter
public class BasePageAction extends BasePage {
    WebDriver driver;

    public BasePageAction() {
        this.driver = Hooks.driver;
    }

    private WebDriverWait wait;

    private ConfigFileReader reader;

    // function generating random emails
    public void enterRandomEmail(String text, String text1, WebElement element, String text3) {
        if (Objects.equals(text, text1)) {
            text3 = getUniqueEmail(text);
        } else {
            text3 = text;
        }
        inputDataToTheField(element, text3);
    }

    // Gets table data from feature file checks if there is certain word in the table to look up in order to generate
    // new random credentials using faker color words random function and fills the form input fields with the data.
    public void enterRandomString(String text, String text1, WebElement element, String text3) {
        Faker faker = new Faker();
        if (Objects.equals(text, text1)) {
            text3 = faker.color().name();
        } else {
            text3 = text;
        }
        inputDataToTheField(element, text3);
    }

    public String getUniqueEmail(String email) {
        String Emails = "ABCDEFGHIJKLMNOPQRSTUVWXY1234567890";
        StringBuilder randomEmail = new StringBuilder();
        Random rnd = new Random();
        while (randomEmail.length() < 10) {
            int index = (int) (rnd.nextFloat() * Emails.length());
            randomEmail.append(Emails.charAt(index));
        }
        String emailString = randomEmail.toString();
        return email.replace("@", emailString + "@");
    }

    // get random password and enter to the confirmation field or get the
    //password confirmation string from the data table.
    public void enterPasswordConfirmation
    (String dataTableName, String valueToCampare, WebElement FieldToInputData,
     String variableName, WebElement elementToGetTextFrom) {
        if (Objects.equals(dataTableName, valueToCampare)) {
            variableName = elementToGetTextFrom.getAttribute("value");
            ;
        } else {
            variableName = dataTableName;
        }
        inputDataToTheField(FieldToInputData, variableName);
    }

    //  random phone number using faker phone number function
    public void enterRandomPhoneNumber(String text, String text1, WebElement element, String text3) {
        Faker faker = new Faker();
        if (Objects.equals(text, text1)) {
            text3 = faker.phoneNumber().cellPhone();
        } else {
            text3 = text;
        }
        inputDataToTheField(element, text3);
    }

    //gets the text from the feature table and WebElement of the field you want to input information
    public void inputDataToTheField(WebElement element, String text) {
        element.clear();
        if (text != null) {
        element.sendKeys(text);
        }
    }

    //get page title and compare to the value in feature Example table with Explicit Wait
    public void getPageTitle(WebDriver driver, String element) {

        String title = driver.getTitle();
        waitFunctionForTitle(driver, title);
        assertEquals(element, title);
    }


    public void compareElementText(WebElement name, String element) {
        String title = name.getText();
        assertEquals(element, title);
    }

    public void compareElementAtributeText(WebElement name, String element) {
        String title = name.getAttribute("innerText");
        assertEquals(element, title);
    }


    ////new Explicit Wait function to wait until web title is present using assertEquals
    public void waitFunctionForTitle(WebDriver webDriver, String element) {

        WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_DURATION);
        wait.until(ExpectedConditions.titleContains(element));
    }

    public static final Duration TIMEOUT_DURATION = Duration.ofSeconds(40);

    public void compareSuccessMessage(WebElement name, String element) {
        String title = name.getText();
        String result = title.replaceAll("\\h*\\R+\\h*", " ").trim();
        String finalResult = result.replaceAll("[^a-zA-Z0-9:!?*]", " ").trim();
        assertEquals(element, finalResult);
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
