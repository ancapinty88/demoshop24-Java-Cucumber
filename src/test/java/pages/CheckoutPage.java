package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@Getter
@Setter
public class CheckoutPage {

    @FindBy(xpath = "//nav[@id='menu']/div/ul/li[3]/a")
    private WebElement componentsCategoryDropdown;
    @FindBy(xpath = "//li[@class='dropdown open']/div/div/ul/li[2]/a")
    private WebElement monitorsSubCategory;
    @FindBy(xpath = "//div[@class='row']/div[2]/div/div[2]/div[@class='button-group']/button[1]")
    private WebElement addToCartBtnOfSamsungSyncMaster;
    @FindBy(xpath = "//div[@id='accordion']/div[2]/div[2]/div/form/div[3]/label/input")
    private WebElement radioButtonNewAddressBillingDetails;
    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-payment-company")
    private WebElement companyNameInput;
    @FindBy(id = "input-payment-address-1")
    private WebElement address1Input;
    @FindBy(id = "input-payment-address-2")
    private WebElement address2Input;
    @FindBy(id = "input-payment-city")
    private WebElement cityNameInput;
    @FindBy(id = "input-payment-postcode")
    private WebElement postCodeInput;
    @FindBy(id = "input-payment-country")
    private WebElement countrySelectDropdown;
    @FindBy(css = "#input-payment-country option[value='123']")
    private WebElement countrySelectDropdownLithuaniaOption;
    @FindBy(id = "input-payment-zone")
    private WebElement region_stateDropdown;
    @FindBy(css = "#input-payment-zone option[value='1920']")
    private WebElement regionVilniusOption;
    @FindBy(css = ".pull-right #button-payment-address")
    private WebElement billingDetailsContinueButton;
    @FindBy(xpath = "//div[@id='accordion']/div[3]/div[2]/div/form/div[3]/label/input")
    private WebElement radioButtonNewAddressDeliveryDetails;
    @FindBy(xpath = "//div[@id='accordion']/div[3]/div/h4/a")
    private WebElement deliveryDetailsTitle;
    @FindBy(id = "input-shipping-firstname")
    private WebElement firstNameInputDe;
    @FindBy(id = "input-shipping-lastname")
    private WebElement lastNameInputDe;
    @FindBy(id = "input-shipping-company")
    private WebElement companyNameInputDe;
    @FindBy(id = "input-shipping-address-1")
    private WebElement address1InputDe;
    @FindBy(id = "input-shipping-address-2")
    private WebElement address2InputDe;
    @FindBy(id = "input-shipping-city")
    private WebElement cityNameInputDe;
    @FindBy(id = "input-shipping-postcode")
    private WebElement postCodeInputDe;
    @FindBy(id = "input-shipping-country")
    private WebElement countrySelectDropdownDe;
    @FindBy(css = "#input-shipping-country option[value='123']")
    private WebElement countrySelectDropdownLithuaniaOptionDe;
    @FindBy(id = "input-shipping-zone")
    private WebElement region_stateDropdownDe;
    @FindBy(css = "#input-shipping-zone option[value='1920']")
    private WebElement regionVilniusOptionDe;
    @FindBy(xpath = "//div[@id='accordion']/div[3]/div/div/form/div/div/input")
    private WebElement continueButtonDeliveryDetails;
    @FindBy(xpath = "//div[@id='accordion']/div[4]/div/h4")
    private WebElement deliveryMethodTitle;
    @FindBy(xpath = "//div[@id='collapse-shipping-method']/div/div/label")
    private WebElement flatRateRadioButtonText;
    @FindBy(xpath = "//div[@id='collapse-shipping-method']/div/div/label/input")
    private WebElement flatRateRadioButton;
    @FindBy(css = ".pull-right #button-shipping-method")
    private WebElement continueButtonDeliveryMethod;
    @FindBy(xpath = "//div[@id='collapse-payment-method']/div/div/label")
    private WebElement paymentMethodRadioButtonText;
    @FindBy(xpath = "//div[@id='collapse-payment-method']/div/div/label/input")
    private WebElement paymentMethodRadioButton;
    @FindBy(css = ".pull-right input[name='agree']")
    private WebElement privacyPolicyAgreementCheckbox;
    @FindBy(css = ".pull-right #button-payment-method")
    private WebElement continueButtonPaymentMethod;
    @FindBy(xpath = "//div[@id='accordion']/div[6]/div/h4")
    private WebElement confirmOrderTitle;
    @FindBy(css = ".pull-right #button-confirm")
    private WebElement confirmOrderButton;
    @FindBy(css ="#top-links .list-inline li a[title = 'Checkout']")
    private WebElement checkoutTopMenuLink;
    @FindBy(xpath = "//div[@id= 'payment-new']/div/label")
    private List<WebElement> requiredBillingDetailsFormFields;

}
