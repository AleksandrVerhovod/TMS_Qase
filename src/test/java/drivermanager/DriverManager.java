package drivermanager;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
//абстрактный класс с абстрактным методом createDriver, который имплементируется у всех наследников,
// опишем все общие методы, чтобы работать с драйвером (размер, таймауты)
public abstract class  DriverManager {
    protected WebDriver driver;
    public abstract void createDriver();
    public WebDriver getDriver() {
        return driver;
    }

    public void startMaximize () {
        driver.manage().window().maximize();
    }

    public void setTimeout () {
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    public void removeTimeout() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void quitDriver () {
        driver.quit();
    }
}
