package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//Хранит в себе драйвер и методы используемые на остальных страницах
public abstract class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isPageOpened();
}
