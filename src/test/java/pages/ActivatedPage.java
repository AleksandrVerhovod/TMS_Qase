package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivatedPage extends BasePage{

    @FindBy (id = "resend")
    private WebElement RESEND_BUTTON;

    @FindBy (xpath = "//a[@id='resend']")
    private WebElement RECEIVED_BUTTON;

    @FindBy (xpath = "//div[@class='error404 text-start']//span")
    private WebElement EMAIL_IS_DISPLAYED;

    public ActivatedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return RESEND_BUTTON.isDisplayed();
    }

    public String isEmailDisplayed() {
        return EMAIL_IS_DISPLAYED.getText();
    }
}
