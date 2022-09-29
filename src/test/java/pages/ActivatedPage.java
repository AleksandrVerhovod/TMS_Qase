package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivatedPage extends BasePage{

    @FindBy (id = "resend")
    private WebElement RESEND_BUTTON;

    @FindBy (xpath = "//a[@id='resend']")
    private WebElement RECEIVED_BUTTON;

    public ActivatedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return RESEND_BUTTON.isDisplayed();
    }

    public boolean isReceivedButtonDisplayed() {
        return RECEIVED_BUTTON.isDisplayed();
    }
}
