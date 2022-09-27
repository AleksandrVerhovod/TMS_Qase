package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {

    //milestone
    private static final String MILESTONE_DEFECT_DROPDOWN_XPATH = "//div[@id='milestoneGroup']//div";
    private static final String SELECT_MILESTONE_DEFECTS_XPATH = "//div[contains(@id, 'react') and text()='%s']";

    //severity
    private static final String SEVERITY_XPATH = "//div[@id='severityGroup']//div";
    private static final String SELECT_SEVERITY_XPATH = "//div[contains(@id, 'react-select') and text() = '%s']";

     //role invite user
    private static final String ROLE_USER_DROPDOWN = "//*[@id=\"roleGroup\"]/div[1]/div";
    private static final String SELECT_ROLE_INVITE_USER_XPATH = "//div[contains(@id,'react-select') and text()='%s']";

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


    public void selectRoleUser (String option) {
        driver.findElement(By.xpath(ROLE_USER_DROPDOWN)).click();
        String listFinalXpath = String.format(SELECT_ROLE_INVITE_USER_XPATH,option);
        driver.findElement(By.xpath(listFinalXpath)).click();
    }


}
