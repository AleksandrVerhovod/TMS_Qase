package elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.PrepareRegistrationData;

public class Checkbox {
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());

    public Checkbox(WebDriver driver, String labelText) {
        this.driver = driver;
    }

    private static final String ROLE_BUTTON_XPATH = "//label[@class='form-check-label' and @for='role-%s']";
    private static final String INDUSTRY_BUTTONS_XPATH = "//label[@class='form-check-label' and @for='industry-%s']";
    private static final String DESCRIBE_BUTTONS_XPATH = "//label[@class='form-check-label' and @for='company-type-%s']";

    public void selectRoleCheckbox(String option) {
        String listFinalXpath = String.format(ROLE_BUTTON_XPATH, option);
        LOGGER.debug(String.format("Select Role checkbox by " + listFinalXpath));
        driver.findElement(By.xpath(listFinalXpath)).click();
    }

    public void selectIndustryCheckbox(String option) {
        String listFinalXpath = String.format(INDUSTRY_BUTTONS_XPATH, option);
        LOGGER.debug(String.format("Select Industry checkbox by %s", listFinalXpath));
        driver.findElement(By.xpath(listFinalXpath)).click();
    }

    public void selectDescribesCheckbox(String option) {
        String listFinalXpath = String.format(DESCRIBE_BUTTONS_XPATH, option);
        LOGGER.debug(String.format("Select Describe checkbox by " + listFinalXpath));
        driver.findElement(By.xpath(listFinalXpath)).click();
    }
}
