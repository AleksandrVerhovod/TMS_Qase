package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(id = "createButton")
    private WebElement CREATE_BUTTON;


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Find Submit button on the Projects Page: %s", CREATE_BUTTON));
        return CREATE_BUTTON.isDisplayed();
    }

    public boolean isCreateButtonDisplayed() {
        return CREATE_BUTTON.isDisplayed();
    }


}
