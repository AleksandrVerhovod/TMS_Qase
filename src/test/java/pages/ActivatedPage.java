package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivatedPage extends BasePage{

    @FindBy (id = "resend")
    private WebElement RESEND_BUTTON;

    @FindBy (xpath = "//h1[text()='Congratulations!']")
    private WebElement CONGRATULATION;

    public ActivatedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return RESEND_BUTTON.isDisplayed();
    }

    public boolean isCongratulationDisplayed () {
        return CONGRATULATION.isDisplayed();
    }
}
