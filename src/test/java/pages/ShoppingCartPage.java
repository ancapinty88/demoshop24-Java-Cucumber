package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
@Setter
public class ShoppingCartPage extends BasePage{
    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    private WebElement itemsAddToCartLinkButton;
    @FindBy(xpath = "//div[2]/div/div[@class='button-group']/button[1]")
    private WebElement iPhoneAddToCartLinkButton;
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[2]/span")
    private WebElement unavailableItemSign;
    @FindBy(xpath = "//div[@id='cart']/button")
    private WebElement blackCartDropdownButton;
    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']/li/table/tbody/tr/td/a/img[@class='img-thumbnail']")
    private WebElement itemsImageBtnInTable;
    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']/li/table/tbody/tr/td[2]/a")
    private WebElement itemsNameBtnInTable;
    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']/li/table/tbody/tr/td[3]")
    private WebElement itemsQuantityBtnInTable;
    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']/li/table/tbody/tr/td[4]")
    private WebElement itemsPriceBtnInTable;
    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td/strong")
    private List<WebElement> lastRequiredItemsInBtnTable;
    @FindBy(xpath = "//div/p[@class='text-right']/a[1]")
    private WebElement viewCartButtonInDropdown;
    @FindBy(xpath = "//div[@class='buttons clearfix']/div[2]/a")
    private WebElement checkoutButtonInShoppingCartPage;
    @FindBy(xpath = "//div/p[@class='text-right']/a[2]")
    private WebElement checkoutButtonDropdown;
    @FindBy(xpath = "//ul[@class='breadcrumb']/li[2]/a")
    private WebElement breadcrumbShoppingCartLink;
    @FindBy(xpath = "//div[@class='input-group btn-block']/span/button[2]")
    private WebElement removeButtonInQuantityItemsRow;
    @FindBy(css = ".table-responsive table tbody tr td div input")
    private WebElement inputFieldInQuantityItemsRow;
    @FindBy(css = "button[data-original-title='Update']")
    private WebElement updateButtonInQuantityItemsRow;
    @FindBy(css = "#error-not-found div div p")
    private WebElement emptyShoppingCartMessage;
    @FindBy(css = "#cart .dropdown-menu li table tbody tr td button")
    private WebElement removeButtonInBlackShoppingCartButtonDropdown;
    @FindBy(css = "header div div div div button #cart-total")
    private WebElement blackShoppingCartEmptyCounterMessage;
    @FindBy(css= "div .alert")
    private WebElement successMessage;
    @FindBy(css ="#top-links .list-inline li a[title = 'Shopping Cart']")
    private WebElement shoppingCartTopMenuLink;
    @FindBy(css ="#content h1")
    private WebElement shoppingCartSubtitle;
    @FindBy(css = "table thead tr td")
    private List<WebElement> requiredFirstTableFields;
    @FindBy(css = "#checkout-cart .row  div .table tbody tr .text-right strong")
    private List<WebElement> requiredSecondTableFields;
    @FindBy(css = ".buttons .pull-left a")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[6]")
    private WebElement totalAddedItemPriceText;

}
