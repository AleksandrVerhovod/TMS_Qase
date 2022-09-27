package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectRepositoryPage extends BasePage{

    @FindBy (xpath = "//a[@class='defect-title' and text()='Demo Project']")
    private WebElement CREATE_CASE_BUTTON;

    @FindBy (xpath = "//span[text()='Import']")
    private WebElement IMPORT_BUTTON;




    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return CREATE_CASE_BUTTON.isDisplayed();
    }

    public boolean isImportButtonDisplayed() {
        return IMPORT_BUTTON.isDisplayed();
    }



}
