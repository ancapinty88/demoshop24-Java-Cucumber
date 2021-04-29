package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import static org.junit.Assert.assertEquals;

public class SampleSteps {
    private WebDriver driver;
    static SamplePage samplePage;

    public SampleSteps() {
        this.driver = Hooks.driver;
        samplePage = PageFactory.initElements(Hooks.driver, SamplePage.class);
    }
}
