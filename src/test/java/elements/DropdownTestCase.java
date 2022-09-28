package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownTestCase {
    private WebDriver driver;
    private String labelText;

    public DropdownTestCase(WebDriver driver,String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }
    //@class='required' and  - BUTTON
    private static final String BUTTON_XPATH = "//label[text()='%s']//..//button[@type='button']";
    private static final String SELECT_OPTION_XPATH = "//div[text()='%s']";
    private static final String BUTTON_MILESTONE_XPATH = "//div[contains(@class,'row')]//label[text()='Milestone']//..//span[@aria-live='polite']//..";

    public void selectOptionsInTestCase(String option) {
        String buttonFinalXpath = String.format(BUTTON_XPATH, labelText);
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

    public void selectOptionsMilestoneInTestCase(String option) {
        String buttonFinalXpath = String.format(BUTTON_MILESTONE_XPATH, labelText);
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }



}
