package elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.PrepareRegistrationData;
import utils.GenerateTestData;

public class Email {
    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());
    private static final String EMAIL_FIELDS_XPATH = "//input[@id='invite%s']";

    private WebDriver driver;

    public Email (WebDriver driver) {
        this.driver = driver;
    }

    public void sendEmailField(String option) {
        String listFinalXpath = String.format(EMAIL_FIELDS_XPATH,option);
        LOGGER.debug(String.format("Send into field %s email", option));
        driver.findElement(By.xpath(listFinalXpath)).sendKeys(GenerateTestData.generateEmail());
    }
}
