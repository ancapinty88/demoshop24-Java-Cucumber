package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.EditAccount_PO;
import pages_sample.General_PO;

import java.util.List;
import java.util.Map;

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

    @And("^User clicks Back button$")
    public void UserClicksBackButton () {
        EditAccountPO.clickBackButton();
    }

    @And("^Data is not entered$")
    public void DataIsNotEntered (Map<String, String> editInput) {
        String FirstNameEntered = editInput.get("First Name");
        String FirstNameActual = GeneralPO.FirstName.getAttribute("value");
        assertNotEquals(FirstNameEntered, FirstNameActual);
        String LastNameEntered = editInput.get("Last Name");
        String LastNameActual = GeneralPO.LastName.getAttribute("value");
        assertNotEquals(LastNameEntered, LastNameActual);
        String EmailEntered = editInput.get("E-Mail");
        String EmailActual = GeneralPO.Email.getAttribute("value");
        assertNotEquals(EmailEntered, EmailActual);
        String TelephoneEntered = editInput.get("Telephone");
        String TelephoneActual = GeneralPO.Telephone.getAttribute("value");
        assertNotEquals(TelephoneEntered, TelephoneActual);
    }

    @And("^Data is entered$")
    public void DataIsEntered (Map<String, String> editInput) {
        String FirstNameEntered = editInput.get("First Name");
        String FirstNameActual = GeneralPO.FirstName.getAttribute("value");
        assertEquals(FirstNameEntered, FirstNameActual);
        String LastNameEntered = editInput.get("Last Name");
        String LastNameActual = GeneralPO.LastName.getAttribute("value");
        assertEquals(LastNameEntered, LastNameActual);
        //String EmailEntered = editInput.get("E-Mail");
        //String EmailActual = GeneralPO.Email.getAttribute("value");
        //assertEquals(EmailEntered, EmailActual);
        String TelephoneEntered = editInput.get("Telephone");
        String TelephoneActual = GeneralPO.Telephone.getAttribute("value");
        assertEquals(TelephoneEntered, TelephoneActual);
    }
}
