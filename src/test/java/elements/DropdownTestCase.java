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
    private static final String BUTTON_XPATH = "//label[@class='required' and text()='%s']//..//button[@type='button']";
    private static final String SELECT_OPTION_XPATH = "//div[@id='modals']//div[text()='%s']";

    public void selectOptionsInTestCase(String option) {
        String buttonFinalXpath = String.format(BUTTON_XPATH, labelText);
        driver.findElement(By.xpath(buttonFinalXpath)).click();
        String optionFinalXpath = String.format(SELECT_OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

}
