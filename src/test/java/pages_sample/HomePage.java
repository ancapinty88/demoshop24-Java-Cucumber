package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stepDefinitions.Hooks.driver;

public class HomePage {

    @FindBy(how = How.ID, using = "")
    private WebElement elem1;
    @FindBy(how = How.NAME, using = "")
    private WebElement elem2;

    public String getHomePageUrl() {
        return "https://www.demoshop24.com/index.php?route=common/home";
    }

    public void verifyThatUserIsOnHomePage() {
        String expectedUrl = getHomePageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
