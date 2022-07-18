package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.EditAccount_PO;
import pages_sample.General_PO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EditAccountSteps {
    private WebDriver driver;
    static EditAccount_PO EditAccountPO;
    static General_PO GeneralPO;

    public EditAccountSteps () {
        this.driver = Hooks.driver;
        EditAccountPO = PageFactory.initElements(Hooks.driver, EditAccount_PO.class);
        GeneralPO = PageFactory.initElements(Hooks.driver, General_PO.class);
    }

    @Then("^Title is \"([^\"]*)\"")
    public void TitleIs (String title) {
        assertEquals(title, EditAccountPO.Title.getText());
    }

    @And("^Subtitle is \"([^\"]*)\"")
    public void SubtitleIs (String subtitle) {
        assertEquals(subtitle, EditAccountPO.Subtitle.getText());
    }

    @And("^User deletes value from field$")
    public void UserDeletesValueFromField (List<String> fields) {
        for (String field : fields) {
            switch (field) {
                case "First Name" :
                    GeneralPO.FirstName.clear();
                    break;
                case "Last Name" :
                    GeneralPO.LastName.clear();
                    break;
                case "E-Mail" :
                    GeneralPO.Email.clear();
                    break;
                case "Telephone" :
                    GeneralPO.Telephone.clear();
                    break;
            }
        }
    }
}
