package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProjectPage extends BasePage{

    @FindBy (xpath = "//button[text()='Create project']")
    private WebElement CREATE_PROJECT_BUTTON;

    @FindBy (xpath = "//input[@id='inputTitle']")
    private WebElement INPUT



    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
