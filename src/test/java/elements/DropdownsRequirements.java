package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownsRequirements {
    private WebDriver driver;
    private String labelText;
    public DropdownsRequirements(WebDriver driver, String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }
    private static final String BUTTON_XPATH = "//label[contains(@class,'control-label') and text()='%s']//..//span[@aria-live='polite']//..";
    private static final String SELECT_OPTION_XPATH = "//div[contains(@id, 'react') and text()='%s']";

    public void selectOptionDefect(String option) {
        String buttonFinalXpath = String.format(BUTTON_XPATH, labelText);
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

}
