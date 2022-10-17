package elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.PrepareRegistrationData;

public class DropdownTestRun {
    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());
    private WebDriver driver;
    private String labelText;

    public DropdownTestRun(WebDriver driver, String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }

    private static final String BUTTON_XPATH = "//label[contains(@class,'control-label') and text()='%s']//..//div[text()]";
    private static final String BUTTON_DEFAULT_ASSIGNEE_XPATH = "//label[contains(@for,'selectAssignee') and text()='%s']//..//div[contains(@class,'notranslate')]";

    private static final String SELECT_OPTION_XPATH = "//div[text()='%s']";

    public void selectOptionTestRun(String option) {
        String buttonFinalXpath = String.format(BUTTON_XPATH, labelText);
        LOGGER.debug(String.format("Click dropdown menu" + labelText));
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        LOGGER.debug(String.format("Select option " + option));
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

    public void selectDefaultAssigneeTestRun(String option) {
        String buttonFinalXpath = String.format(BUTTON_DEFAULT_ASSIGNEE_XPATH, labelText);
        LOGGER.debug(String.format("Click dropdown menu" + labelText));
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        LOGGER.debug(String.format("Select option " + option));
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }
}
