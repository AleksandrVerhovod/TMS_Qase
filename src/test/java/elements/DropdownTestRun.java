package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownTestRun {

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
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

    public void selectDefaultAssigneeTestRun(String option) {
        String buttonFinalXpath = String.format(BUTTON_DEFAULT_ASSIGNEE_XPATH, labelText);
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }
}
