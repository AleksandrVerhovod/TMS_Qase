package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdowns {
    private WebDriver driver;
    private String labelText;
    public Dropdowns(WebDriver driver, String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }
    //milestone
    private static final String BUTTON_XPATH = "//label[contains(@class,'control-label') and text()='%s']//..//div[1]";
    private static final String SELECT_OPTION_XPATH = "//div[contains(@id, 'react') and text()='%s']";

    public void selectOptionDefect(String option) {
        String buttonFinalXpath = String.format(BUTTON_XPATH, labelText);
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }


}
