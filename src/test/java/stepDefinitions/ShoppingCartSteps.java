package stepDefinitions;

import action.*;
import io.cucumber.java.en.*;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.ShoppingCartPage;
import pages.WishListPage;
import utils.ConfigFileReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter
@Setter
public class ShoppingCartSteps extends BasePage {

    WebDriver driver;
    static ConfigFileReader configFileReader;
    BasePage basePage;
    BasePageAction basePageAction;
    WishListPage wishListPage;
    ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        basePage = new BasePage();
        basePageAction = new BasePageAction();
        wishListPage = new WishListPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Then("user see that there is {string} in the shopping cart")
    public void userSeeThatThereIsInTheShoppingCart(String arg0) {
        basePageAction.compareElementText(shoppingCartPage.getBlackShoppingCartEmptyCounterMessage(), arg0);
    }

    @And("user see table with mandatory fields")
    public void userSeeTableWithMandatoryFields(List<String> tableFields) {
        List<String> requiredTableFields = basePageAction.getMandatoryTableFields(shoppingCartPage.getLastRequiredItemsInBtnTable());
        assertEquals(tableFields, requiredTableFields);
    }

    @Then("user see table fields")
    public void userSeeTableFields(List<String> tableFields) {
        List<String> requiredTableFields = basePageAction.getMandatoryTableFields(shoppingCartPage.getRequiredFirstTableFields());
        assertEquals(tableFields, requiredTableFields);
    }

    @And("user see down table fields")
    public void userSeeDownTableFields(List<String> tableFields) {
        List<String> requiredTableFields = basePageAction.getMandatoryTableFields(shoppingCartPage.getRequiredSecondTableFields());
        assertEquals(tableFields, requiredTableFields);
    }

    @Then("user increase {string} value in quantity column")
    public void userIncreaseValueInQuantityColumn(String arg0) {
        basePageAction.inputDataToTheField(shoppingCartPage.getInputFieldInQuantityItemsRow(), arg0);
    }

    @Then("user see {string}")
    public void userSee(String arg0) {
        basePageAction.compareSuccessMessage(shoppingCartPage.getSuccessMessage(), arg0);
    }

    @Then("user see {string} message")
    public void userSeeMessage(String arg0) {
        basePageAction.compareElementText(shoppingCartPage.getEmptyShoppingCartMessage(), arg0);
    }

    @Then("user see {string} added item to shopping cart")
    public void userSeeAddedItemToShoppingCart(String arg0) {
        basePageAction.compareSuccessMessage(shoppingCartPage.getSuccessMessage(), arg0);
    }

    @When("user see {string} added item is unavailable")
    public void userSeeAddedItemIsUnavailable(String arg0) {
        basePageAction.compareSuccessMessage(shoppingCartPage.getSuccessMessage(), arg0);
    }

    @And("user see {string} next to the items name")
    public void userSeeNextToTheItemsName(String arg0) {
        basePageAction.compareElementText(shoppingCartPage.getUnavailableItemSign(), arg0);
    }
}
