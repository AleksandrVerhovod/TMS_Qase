package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dropdown {
    private static final String MILESTONE_DEFECT_DROPDOWN_XPATH = "//div[@id='milestoneGroup']//div";
    private static final String SELECT_MILESTONE_DEFECTS_XPATH = "//div[contains(@id, 'react') and text()='%s']";

    private static final String SEVERITY_XPATH = "//div[@id='severityGroup']//div";
    private static final String SELECT_SEVERITY_XPATH = "//div[contains(@id, 'react-select') and text() = '%s']";

    private WebDriver driver;
    public Dropdown (WebDriver driver) {
        this.driver = driver;
    }
    public void selectMilestoneDefect (String option) {
        driver.findElement(By.xpath(MILESTONE_DEFECT_DROPDOWN_XPATH)).click();
        String listFinalXpath = String.format(SELECT_MILESTONE_DEFECTS_XPATH,option);
        driver.findElement(By.xpath(listFinalXpath)).click();
    }

    public void selectSeverityDefect (String option) {
        driver.findElement(By.xpath(SEVERITY_XPATH)).click();
        String listFinalXpath = String.format(SELECT_SEVERITY_XPATH,option);
        driver.findElement(By.xpath(listFinalXpath)).click();
    }


}
