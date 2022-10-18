package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivatedPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ActivatedPage.class.getName());
    @FindBy(id = "resend")
    private WebElement RESEND_BUTTON;

    @FindBy(xpath = "//a[@id='resend']")
    private WebElement RECEIVED_BUTTON;

    @FindBy(xpath = "//div[@class='error404 text-start']//span")
    private WebElement EMAIL_IS_DISPLAYED;

    public ActivatedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", RESEND_BUTTON));
        return RESEND_BUTTON.isDisplayed();
    }

    public String isEmailDisplayed() {
        LOGGER.debug(String.format("Attempt to find email: %s", EMAIL_IS_DISPLAYED.getText()));
        return EMAIL_IS_DISPLAYED.getText();
    }
}
