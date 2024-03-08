package pages;


import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@Getter
@Setter
public class WishListPage extends BasePage{

    //elements:
    @FindBy(xpath = "//aside[@id='column-right']/div/a[5]")
    private WebElement wishListSumMenLink;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/a[2]")
    private WebElement wishListLinkInSuccessMessage;
    @FindBy(css= "#logo h1 a")
    private WebElement demoShopLogoLink;
    @FindBy(xpath = "//div[@class='button-group']/button[2]")
    private WebElement addToWishListButton;
    @FindBy(xpath ="//ul[@class='list-inline']/li[3]/a")
    private WebElement wishListTopMenuLink;
    @FindBy(css= ".buttons .pull-right a")
    private WebElement wishListContinueButton;
    @FindBy(css= "div .alert")
    private WebElement successMessage;
    @FindBy(css = "table thead tr td")
    private List<WebElement> requiredTableFields;
    @FindBy(css= ".table-responsive tbody tr .text-right button")
    private WebElement addToCartButtonInTheTable;
    @FindBy(css= ".table-responsive tbody tr .text-right a")
    private WebElement removeButtonInTheTable;
}
