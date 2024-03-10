package utils;


import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static action.PasswordPageAction.TIMEOUT_DURATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static stepDefinitions.Hooks.driver;

@Getter
@Setter
//only common methods
public class Helper {

    //action methods:

    public static void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public static void clickGivenElement(WebDriver driver, WebElement element) {
        element.click();
    }

    //new Explicit Wait function to wait until web element is present
    public void WaitFunction (WebDriver webDriver,  WebElement element) {

        WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_DURATION);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void inputDataToField(WebElement element, String text) {

        element.clear();
        element.sendKeys(text);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    //function to get page title and compare to the value in feature Example table with Explicit Wait



//assert methods:
    public void assertElementIsDisplayed(WebElement element) {

      assertTrue(element.isDisplayed(), "Element is not displayed!");
    }

    public static void assertFoundElementIsALink(WebElement element) {

        assertTrue(element.getTagName().equalsIgnoreCase("a"), "Element is not a link!");
    }

    public void assertElementIsEnabled(WebElement element) {

        assertTrue(element.isEnabled(), "Element is not enabled!");

    }

    public static void assertElementTextMatchesInput(String inputTitle, WebElement element) {
        assertEquals(inputTitle, element.getText(), "Element Text doesn't match input!");
        }

//wait methods:
    public static void waitForElementToBeVisible(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementsInsideObjectToLoad(WebDriverWait wait, WebElement object) {
        wait.until(ExpectedConditions.visibilityOfAllElements(object));
    }








                //wait methods:
//    public static void waitForElementToBeVisible(WebElement element, WebDriverWait wait) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public static void waitForElementToBeClickable(WebElement element, WebDriverWait wait) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//
//    public static void waitForElementsInsideObjectToLoad(WebDriverWait wait, WebElement object) {
//        wait.until(ExpectedConditions.visibilityOfAllElements(object));
//    }

//    public static String getPageUrl(String pageName) {
//        final String BASE_URL = "https://www.demoshop24.com/index.php?route=common/home";
//        String url = BASE_URL;
//        switch (pageName.toLowerCase()) {
//            case "Registration":
//                url += "Register";
//                break;
//            case "login":
//                url += "Login";
//                break;
//            // Add more cases for other pages as needed
//            default:
//                throw new IllegalArgumentException("Unsupported page name: " + pageName);
//        }
//        return url;
//    }

//    public static void clickLoginOption() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(loginOption));
//        clickElement(loginOption);//common
//    }
//new
//    public void enterText(WebElement element, String text) {
//        element.sendKeys(text);
//    }
//
//
//    public void eraseText(WebElement element) {
//        element.clear();
//    }
//    public String textGetter(WebElement element) {
//        return element.getText();
//    }
//    public String attributeGetter(WebElement element) {
//        return element.getAttribute("value");
//    }
////    public void visibleElement(WebElement element) {
////        element.isDisplayed();
////    }
//    public boolean visibleStringText(String element) {
//        return element != null && !element.isEmpty();
//    }
//
//    public void assertElementIsDisplayed(WebElement element) {
//        assertTrue(element.isDisplayed(), "Element is not displayed!");
//    }
//
//    public boolean isElementDisplayed(WebElement element) {
//        try {
//            return element.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }

//        public static void waitUntilElementIsVisible(WebElement element) {
//            wait.until(ExpectedConditions.visibilityOf(element));
//        }
//
//        public static void waitUntilTextIsPresentInElement(WebElement element, String expectedText) {
//            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
//        }
//
//        public static void sendKeysToElement(WebElement element, String keysToSend) {
//            wait.until(ExpectedConditions.visibilityOf(element));
//            element.clear();
//            element.sendKeys(keysToSend);
//        }
//
//        public static void clickElement(WebElement element) {
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//            element.click();
//        }
//        public static void verifyThatElementIsDisplayed(WebElement element) {
//            waitUntilElementIsVisible(element);
//            assertTrue(element.isDisplayed());
//        }
//        public void assertThatTextIsCorrect(String expectedText, WebElement element) {
//            waitUntilTextIsPresentInElement(element, expectedText);
//            assertEquals(expectedText, element.getText());
//        }
//
//        public void assertThatInformationOfUserIsCorrect(String expectedText, WebElement element) {
//            assertEquals(expectedText, element.getAttribute("value"));
//        }


}

