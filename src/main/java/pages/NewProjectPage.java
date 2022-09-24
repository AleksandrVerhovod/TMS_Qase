package pages;

import org.openqa.selenium.WebDriver;

public class NewProjectPage extends BasePage{



    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
