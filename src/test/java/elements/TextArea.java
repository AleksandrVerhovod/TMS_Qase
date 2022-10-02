package elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.PrepareRegistrationData;

public class TextArea {
    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());
    private static final String TEXT_AREA_XPATH = "//div[@id='application-content']//label[text()='%s']//..//p";
    private String labelText;
    private WebDriver driver;

    public TextArea(WebDriver driver,String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }

    public void inputTextArea (String text) {
        String finalXpath = String.format(TEXT_AREA_XPATH,labelText);
        LOGGER.debug(String.format("Send text into " + labelText));
        driver.findElement(By.xpath(finalXpath)).sendKeys(text);
    }
}
