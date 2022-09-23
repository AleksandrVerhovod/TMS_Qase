package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Email {

    private static final String EMAIL_FIELDS_XPATH = "//input[@id='invite%s']";
   private String labelText;
    private WebDriver driver;

    public Email (WebDriver driver,String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }

    public void sendEmailField(String text) {
        String listFinalXpath = String.format(EMAIL_FIELDS_XPATH,labelText);
        driver.findElement(By.xpath(listFinalXpath)).sendKeys(text);
    }
}
