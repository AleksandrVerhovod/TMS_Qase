package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenerateTestData;

public class Email {

    private static final String EMAIL_FIELDS_XPATH = "//input[@id='invite%s']";
   private String labelText;
    private WebDriver driver;

    public Email (WebDriver driver) {
        this.labelText = labelText;
        this.driver = driver;
    }

    public void sendEmailField(String option) {
        String listFinalXpath = String.format(EMAIL_FIELDS_XPATH,option);
        driver.findElement(By.xpath(listFinalXpath)).sendKeys(GenerateTestData.generateEmail());
    }
}
