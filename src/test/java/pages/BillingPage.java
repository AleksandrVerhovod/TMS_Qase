package pages;

import models.CreateProjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BillingPage extends BasePage{


    @FindBy (xpath = "//span[@class=\"subscription-current\"]")
    private WebElement CURRENT_PLAN_TITLE;

    @FindBy (xpath = "//button[@id=\"upgrade\"]")
    private WebElement BUTTON_UPGRADE;

    @FindBy (xpath = "//a[@class=\"mt-3 btn btn-primary\"]")
    private WebElement BUTTON_ADD_PAYMENT;

    @FindBy (xpath = "//div[@class=\"modal-body\"]//div[@id=\"startup-plan\"]//a")
    private WebElement BUTTON_STARTUP_START_TRIAL;

    @FindBy (xpath = "//select[@id=\"plan_users\"]")
    private  WebElement DROP_DOWN_USERS;

    @FindBy (xpath = "//select[@id=\"plan_period\"]")
    private  WebElement DROP_DOWN_PERIOD;

    @FindBy (xpath = "//a[@id='purchase-button']")
    private WebElement BUTTON_START_30d_FREE_TRIAL;

    @FindBy (xpath = "//a[@id='close-congratulations-modal']")
    private WebElement BUTTON_CLOSE_CONGRATULATION_MODAL;

    @FindBy (xpath = "//h2[@class='subscription-title' and text()='Startup']")
    private WebElement NAME_SUBSCRIPTION_PLAN;

    @FindBy (xpath = "//a[@class='btn btn-sm btn-cancel']")
    private WebElement BUTTON_CANCEL_TRIAL;

    @FindBy (xpath = "//a[@id='resumeTrial']")
    private  WebElement BUTTON_RESUME_TRIAL;

    @FindBy (xpath = "//a[@id='quantity-button']")
    private WebElement UPDATE_QUANTITY_USERS;

    @FindBy (xpath = "//div[@class='modal-content']//button[@data-id='quantity']")
    private WebElement DROPDOWN_QUANTITY_USERS;

    @FindBy (xpath = "//a[@id=\'update-quantity-button\']")
    private WebElement UPDATE_QUANTITY_BUTTON;

    @FindBy (xpath = "//span[@data-qase-test='max-users']")
    private WebElement MAX_USERS_INFO;

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return CURRENT_PLAN_TITLE.isDisplayed();
    }


    public BillingPage clickButtonUpdateQuantity () {
        UPDATE_QUANTITY_BUTTON.click();
        return this;
    }

    public BillingPage selectQuantity () {
        DROPDOWN_QUANTITY_USERS.click();
        return this;
    }


}
